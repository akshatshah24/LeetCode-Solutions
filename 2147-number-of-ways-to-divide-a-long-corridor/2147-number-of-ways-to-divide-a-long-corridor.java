class Solution {
    public int numberOfWays(String corridor) {
        int numOfSeats = 0;
        int numOfPlants = 0;
        long divider = 1;

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                numOfSeats++;
            }
            if (corridor.charAt(i) == 'P' && numOfSeats == 2) {
                numOfPlants++;
            }
            if (numOfSeats == 3) {
                divider *= (numOfPlants + 1);
                divider %= 1000000007;
                numOfSeats = 1;
                numOfPlants = 0;
            }
        }

        if (numOfSeats < 2) {
            return 0;
        }

        return (int) divider;
    }
}