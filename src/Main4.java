import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] str = n.split(",");
        Map<String, Object> trMap = new HashMap<>();
        for (String s : str) {
            String[] line = s.trim().split("");
            String star = line[0];
            String end = line[1];
            Integer l = Integer.parseInt(line[2]);
            Map<String, Integer> zMap = new HashMap<>();
            if (trMap.containsKey(star)) {
                zMap = (Map<String, Integer>) trMap.get(star);
            }
            zMap.put(end, l);
            trMap.put(star, zMap);

        }
        //  AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
        // 1
        try {
            System.out.println(find1(trMap, "A", "B") + find1(trMap, "B", "C"));
        } catch (NullPointerException e) {
            System.out.println(" NO SUCH ROUTE");
        }

        // 2
        try {
            System.out.println(find1(trMap, "A", "D"));
        } catch (NullPointerException e) {
            System.out.println(" NO SUCH ROUTE");
        }

        // 3
        try {
            System.out.println(find1(trMap, "A", "D") + find1(trMap, "D", "C"));
        } catch (NullPointerException e) {
            System.out.println(" NO SUCH ROUTE");
        }
        // 4
        try {
            System.out.println(find1(trMap, "A", "E") + find1(trMap, "E", "B") +
                    find1(trMap, "B", "C") + find1(trMap, "C", "D"));
        } catch (NullPointerException e) {
            System.out.println(" NO SUCH ROUTE");
        }

        // 5
        try {
            System.out.println(find1(trMap, "A", "E") + find1(trMap, "E", "D"));
        } catch (NullPointerException e) {
            System.out.println("NO SUCH ROUTE");
        }

        // 6
        System.out.println(find2(trMap, "C", "C", 3));

        // 7
        System.out.println(find3(trMap, "A", "C", 4));

        //8
        try {
            System.out.println(find4(trMap, "A", "C"));
        } catch (Exception e) {
            System.out.println("NO SUCH ROUTE");
        }

        //9
        try {
            System.out.println(find4(trMap, "B", "B"));
        } catch (Exception e) {
            System.out.println("NO SUCH ROUTE");
        }

        // 10
        try {
            List<Integer> list = new ArrayList<>();
            find5(trMap, list, "C", "C", 0);
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println("NO SUCH ROUTE");
        }
    }

    private static Integer find1(Map<String, Object> map, String star, String target) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals(star)) {
                Map<String, Integer> zMap = (Map<String, Integer>) entry.getValue();
                for (Map.Entry<String, Integer> entry2 : zMap.entrySet()) {
                    if (entry2.getKey().equals(target)) {
                        return entry2.getValue();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 查询行程数量
     *
     * @param map
     * @param star
     * @param target
     * @param max
     * @return
     */
    private static Integer find2(Map<String, Object> map, String star, String target, Integer max) {
        int l = 0;
        Set<String> set = new LinkedHashSet<>();
        set.add(star);
        for (int i = 0; i < max; i++) {
            Set<String> removeSet = new LinkedHashSet<>();
            removeSet.addAll(set);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (removeSet.contains(entry.getKey())) {
                    Map<String, Integer> zMap = (Map<String, Integer>) entry.getValue();
                    for (Map.Entry<String, Integer> entry2 : zMap.entrySet()) {
                        if (entry2.getKey().equals(target)) {
                            l++;
                            set.remove(entry.getKey());
                        } else {
                            set.add(entry2.getKey());
                        }
                    }
                }
            }
            set.removeAll(removeSet);
        }
        return l;
    }

    private static Integer find3(Map<String, Object> map, String star, String target, Integer max) {
        int l = 0;
        Set<String> set = new LinkedHashSet<>();
        set.add(star);
        for (int i = 0; i < max; i++) {
            Set<String> removeSet = new LinkedHashSet<>();
            removeSet.addAll(set);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (removeSet.contains(entry.getKey())) {
                    Map<String, Integer> zMap = (Map<String, Integer>) entry.getValue();
                    for (Map.Entry<String, Integer> entry2 : zMap.entrySet()) {
                        if (entry2.getKey().equals(target) && i == (max - 1)) {
                            l++;
                            set.remove(entry.getKey());
                        } else {
                            set.add(entry2.getKey());
                        }
                    }
                }
            }
            set.removeAll(removeSet);
        }
        return l;
    }

    private static Integer find4(Map<String, Object> map, String star, String target) {
        Set<String> set = new LinkedHashSet<>();
        set.add(star);
        Map<String, Integer> lMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (true) {
            Set<String> nowSet = new LinkedHashSet<>();
            nowSet.addAll(set);
            set.clear();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (nowSet.contains(entry.getKey())) {
                    Map<String, Integer> zMap = (Map<String, Integer>) entry.getValue();
                    for (Map.Entry<String, Integer> entry2 : zMap.entrySet()) {
                        if (entry2.getKey().equals(target)) {
                            if (lMap.containsKey(entry.getKey())) {
                                list.add(lMap.get(entry.getKey()) + entry2.getValue());
                            } else {
                                list.add(entry2.getValue());
                            }
                            break;
                        } else {
                            if (lMap.containsKey(entry.getKey())) {
                                Integer l = lMap.get(entry.getKey());
                                lMap.remove(entry.getKey());
                                lMap.put(entry2.getKey(), l + entry2.getValue());
                            } else {
                                lMap.put(entry2.getKey(), entry2.getValue());
                            }
                            set.add(entry2.getKey());
                        }
                    }
                }
            }
            i++;
            if (set.size() == 0 || i > 100) {
                break;
            }
        }
        Collections.sort(list);
        return list.get(0);
    }

    private static void find5(Map<String, Object> map, List<Integer> list, String path, String target,
                              Integer l) {
        if (l >= 30) {
            return;
        }
        if (l > 0 && path.endsWith(target)) {
            list.add(l);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (path.endsWith(entry.getKey())) {
                Map<String, Integer> zMap = (Map<String, Integer>) entry.getValue();
                for (Map.Entry<String, Integer> entry2 : zMap.entrySet()) {
                    String newPath = path + entry2.getKey();
                    Integer newL = l + entry2.getValue();
                    find5(map, list, newPath, target, newL);
                }
            }
        }
    }
}
