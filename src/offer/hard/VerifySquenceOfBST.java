package offer.hard;

public class VerifySquenceOfBST {
    public boolean helpVerify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int endVal = sequence[end];
        int split = start;
        while (split < end && sequence[split] < endVal) {
            split++;
        }
        for (int i = split; i < end; i++) {
            if (sequence[i] < endVal) {
                return false;
            }
        }
        return helpVerify(sequence, start, split - 1) && helpVerify(sequence, split, end - 1);

    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helpVerify(sequence, 0, sequence.length - 1);
    }
}
