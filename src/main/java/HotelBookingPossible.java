import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Booking example
/*
1---------10
 2
  3--6
   4-------------14
*/

//Another Booking example
/*
12
 23
  34
*/


public class HotelBookingPossible {
    public static void main(String[] args) {
        List<Integer> arrive = Arrays.asList(1, 2, 3, 4);
        List<Integer> depart = Arrays.asList(10, 2, 6, 14);
        int K = 4; //true

        //Another Test case
        //List<Integer> arrive = Arrays.asList(1, 2, 3);
        //List<Integer> depart = Arrays.asList(2, 3, 4);
        //int K = 1; //true

        HotelBookingPossible hotelBookingPossible = new HotelBookingPossible();
        System.out.println(hotelBookingPossible.hotel(arrive, depart, K));
    }

    private boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        int arrivalLength = arrive.size();
        int departureLength = depart.size();

        Collections.sort(arrive);
        Collections.sort(depart);

        int arrivalIndex = 0;
        int departureIndex = 0;
        int count = 0;

        while (arrivalIndex < arrivalLength && departureIndex < departureLength) {
            if (arrive.get(arrivalIndex) < depart.get(departureIndex)) {
                count++;
                arrivalIndex++;
            } else {
                count--;
                departureIndex++;
            }

            if (count > K)
                return false;
        }

        if (departureIndex == departureLength) {
            return arrivalLength - arrivalIndex + count + 1 <= K;
        }

        return true;
    }
}