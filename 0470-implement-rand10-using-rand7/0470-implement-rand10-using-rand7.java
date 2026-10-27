class Solution extends SolBase {
    public int rand10() {
        int x;
        do {
            // Generate one of 49 equally likely outcomes: 1–49.
            x = (rand7() - 1) * 7 + rand7();
        } while (x > 40); // Reject 41–49 to remove bias.

        // Map 1–40 uniformly to 1–10.
        return (x - 1) % 10 + 1;
    }
}