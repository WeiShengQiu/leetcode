package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            Date sDate = new SimpleDateFormat("HH:mm").parse(str);
            Calendar scal = Calendar.getInstance();
            scal.setTime(sDate);

            str = str.replace(":", "");
            List<String> strList = Arrays.asList(str.split(""));
            List<Integer> intList = new ArrayList<>();
            for (String s : strList) {
                int i = Integer.parseInt(s);
                intList.add(i);
            }
            Set<Date> dateSet = new HashSet<>();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
            Date day2 = new SimpleDateFormat("HHmm").parse("2400");
            for (Integer a : intList) {

                String dateStr1 = "" + a + a + a + a;
                Date date1 = sdf.parse(dateStr1);
                if (date1.compareTo(day2) < 1 && Integer.parseInt("" + a + a) <= 24 && Integer.parseInt("" + a + a) < 60) {

                    dateSet.add(date1);
                }

                for (Integer b : intList) {
                    String dateStr2 = "" + a + b + b + b;
                    Date date2 = sdf.parse(dateStr2);
                    if (date2.compareTo(day2) < 1 && Integer.parseInt("" + a + b) <= 24 && Integer.parseInt("" + b + b) <= 60) {
                        dateSet.add(date2);
                    }
                    for (Integer c : intList) {
                        String dateStr3 = "" + a + b + c + c;
                        Date date3 = sdf.parse(dateStr3);
                        if (date3.compareTo(day2) < 1 && Integer.parseInt("" + a + b) <= 24 && Integer.parseInt("" + c + c) <= 60) {
                            dateSet.add(date3);
                        }
                        for (Integer d : intList) {
                            String dateStr4 = "" + a + b + c + d;
                            Date date4 = sdf.parse(dateStr4);
                            if (date4.compareTo(day2) < 1 && Integer.parseInt("" + a + b) <= 24 && Integer.parseInt(
                                    "" + c + d) <= 60) {
                                dateSet.add(date4);
                            }
                        }
                    }
                }
            }
            long i = 999999999;
            Date result = new Date();
            for (Date date : dateSet) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                long j = cal.getTimeInMillis() - scal.getTimeInMillis();
                if (j < 0) {
                    cal.add(Calendar.DAY_OF_YEAR, 1);
                    long k = cal.getTimeInMillis() - scal.getTimeInMillis();
                    if (k < i && k > 0) {
                        i = k;
                        result = date;
                    }
                } else {
                    if (j < i && j > 0) {
                        i = j;
                        result = date;
                    }
                }


            }
            System.out.println(new SimpleDateFormat("HH:mm").format(result));
        }
    }
}
