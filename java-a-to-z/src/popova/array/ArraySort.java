package popova.array;

public class ArraySort {

    public int[] sort(int[] first, int[] second) {

        int[] sortMass = new int[first.length + second.length];
        int countF = 0;
        int countS = 0;
        int min = first.length >= second.length ? first.length : second.length;
        int max = first.length >= second.length ? second.length : first.length;

        for(;countF + countS < sortMass.length; ) {

            if( countS == first.length || countF < min && first[countF] < second[countS] ){
                sortMass[countF + countS] = first[countF++];
            }
            else {
                sortMass[countF + countS] = second[countS++];
            }
        }
        return sortMass;
    }
}
