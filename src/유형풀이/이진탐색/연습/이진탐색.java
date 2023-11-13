package 유형풀이.이진탐색.연습;

public class 이진탐색 {

        // 이진탐색은 원하는 값이 존재하는 인덱스를 찾아내는 방법이다.
//        public static int binarySearch(int[] arr, int target, int start, int end) {
//
//            while (start <= end) {
//
//                int mid = (start + end) / 2;
//                // 찾은 경우 중간점 인덱스 반환
//                if (arr[mid] == target) return mid;
//                    // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
//                else if (arr[mid] > target) end = mid - 1;
//                    // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
//                else start = mid + 1;
//            }
//
//            return -1;
//        }

    public static int binarySearch(int[] arr, int target, int start, int end)
    {
        while(start <= end)
        {
            int mid = (start + end) / 2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) end = mid - 1; // 현재 커서 위치가 찾고자 하는 값보다 크다면 밑에서 검색
            else start = mid + 1;
        }

        return -1; // 없으면 예외 케이스 반환
    }

    public static void main(String[] args) {

    }
}
