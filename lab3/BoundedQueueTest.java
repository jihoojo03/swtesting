public class BoundedQueueTest {

        static int[] capacity = {0, 1, 4};
        static int[] size = {0, 1, 2};
        static String[][] values = {{}, {"happy"}, {"happy", "man"}};
        static String[] obj = {null, "yes"};
        static Object[] basic = {4, false, false, 2};

        public static BoundedQueue basicQueue() throws Exception {
                BoundedQueue Q = new BoundedQueue(capacity[2]);

                for (int i = 0; i < size[2]; i++)
                        Q.enqueue(values[1][i]);

                return Q;
        }

        public static BoundedQueue makeQueue(int cap, int size) throws Exception{
                BoundedQueue Q = new BoundedQueue(cap);

                for (int i = 0; i < size; i++)
                        Q.enqueue(values[size][i]);

                return Q;
        }


        public static void printResult(String msg, int num, boolean flag) {
                if (flag){
                        System.out.println(msg + "(" + num + ") : Normal Case");
                }
                else {
                        System.out.println(msg + "(" + num + ") : Exception Case");
                }

        }

        public static void printResult(String msg, int cap, boolean isEmpty, boolean isFull, int size, int flag) {
                if (flag == 0){
                        System.out.println(msg + "(Capacity : " + cap + ", Size : " + size + ", isEmpty : " + isEmpty + ", isFull : " + isFull +") : Expected Result");
                }
                else if (flag == 1){
                        System.out.println(msg + "(Capacity : " + cap + ", Size : " + size + ", isEmpty : " + isEmpty + ", isFull : " + isFull +") : Wrong Result");
                }
                else{
                        System.out.println(msg + "(Capacity : " + cap + ", Size : " + size + ", isEmpty : " + isEmpty + ", isFull : " + isFull +") : Exception Case");
                }
        }

        public static void printResult(String msg, int cap, boolean isEmpty, boolean isFull, int size, String obj, int flag) {
                if (flag == 0){
                        System.out.println(msg + "(Capacity : " + cap + ", Size : " + size + ", isEmpty : " + isEmpty + ", isFull : " + isFull + ", Obj : " + obj + ") : Expected Result");
                }
                else if (flag == 1){
                        System.out.println(msg + "(Capacity : " + cap + ", Size : " + size + ", isEmpty : " + isEmpty + ", isFull : " + isFull + ", Obj : " + obj + ") : Wrong Result");
                }
                else{
                        System.out.println(msg + "(Capacity : " + cap + ", Size : " + size + ", isEmpty : " + isEmpty + ", isFull : " + isFull + ", Obj : " + obj + ") : Exception Case");
                }
        }

        public static boolean constructorCheck(int cap) throws Exception {
                boolean flag = true;

                try {
                        BoundedQueue Q = new BoundedQueue(cap);
                        flag = true;
                }
                catch (Exception e) {
                        flag = false;
                }

                return flag;
        }

        public static void constructorTest() throws Exception {
                System.out.println("***** Consturctor Test *****");
                for (int i = 0; i < capacity.length; i++) {
                        int cap = capacity[i];
                        printResult("ConstructorTest", cap, constructorCheck(cap));
                }
        }


        public static void isFullTest() throws Exception {

                System.out.println("***** isFullTest *****");
                printResult("isFullTest", capacity[2], false, false, size[2], isFullCheck(capacity[2], false, false, size[2]));
                printResult("isFullTest", capacity[1], false, false, size[2], isFullCheck(capacity[1], false, false, size[2]));
                printResult("isFullTest", capacity[0], false, false, size[2], isFullCheck(capacity[0], false, false, size[2]));
                printResult("isFullTest", capacity[2], true, false, size[2], isFullCheck(capacity[2], true, false, size[2]));
                printResult("isFullTest", capacity[2], false, true, size[2], isFullCheck(capacity[2], false, true, size[2]));
                printResult("isFullTest", capacity[2], false, false, size[1], isFullCheck(capacity[2], false, false, size[1]));
                printResult("isFullTest", capacity[2], false, false, size[0], isFullCheck(capacity[2], false, false, size[0]));

        }

        public static int isEmptyCheck(int cap, boolean isEmpty, boolean isFull, int size) throws Exception {
                int flag = 0;
                BoundedQueue Q = null;

                try {
                        Q = makeQueue(cap, size);
                        if (Q.isEmpty() != isEmpty)
                                flag = 1;

                }
                catch (Exception e) {
                        flag = -1;
                }

                return flag;
        }

        public static void isEmptyTest() throws Exception {

                System.out.println("***** isEmptyTest *****");
                printResult("isEmptyTest", capacity[2], false, false, size[2], isEmptyCheck(capacity[2], false, false, size[2]));
                printResult("isEmptyTest", capacity[1], false, false, size[2], isEmptyCheck(capacity[1], false, false, size[2]));
                printResult("isEmptyTest", capacity[0], false, false, size[2], isEmptyCheck(capacity[0], false, false, size[2]));
                printResult("isEmptyTest", capacity[2], true, false, size[2], isEmptyCheck(capacity[2], true, false, size[2]));
                printResult("isEmptyTest", capacity[2], false, true, size[2], isEmptyCheck(capacity[2], false, true, size[2]));
                printResult("isEmptyTest", capacity[2], false, false, size[1], isEmptyCheck(capacity[2], false, false, size[1]));
                printResult("isEmptyTest", capacity[2], false, false, size[0], isEmptyCheck(capacity[2], false, false, size[0]));

        }



        public static int dequeueCheck(int cap, boolean isEmpty, boolean isFull, int size) throws Exception {
                int flag = 0;
                BoundedQueue Q = null;

                try {
                        Q = makeQueue(cap, size);
                        if (!Q.dequeue().equals("happy"))
                                flag = 1;

                }
                catch (Exception e) {
                        flag = -1;
                }

                return flag;
        }

        public static void dequeueTest() throws Exception {

                System.out.println("***** dequeueTest *****");
                printResult("dequeueTest", capacity[2], false, false, size[2], isEmptyCheck(capacity[2], false, false, size[2]));
                printResult("dequeueTest", capacity[1], false, false, size[2], isEmptyCheck(capacity[1], false, false, size[2]));
                printResult("dequeueTest", capacity[0], false, false, size[2], isEmptyCheck(capacity[0], false, false, size[2]));
                printResult("dequeueTest", capacity[2], true, false, size[2], isEmptyCheck(capacity[2], true, false, size[2]));
                printResult("dequeueTest", capacity[2], false, true, size[2], isEmptyCheck(capacity[2], false, true, size[2]));
                printResult("dequeueTest", capacity[2], false, false, size[1], isEmptyCheck(capacity[2], false, false, size[1]));
                printResult("dequeueTest", capacity[2], false, false, size[0], isEmptyCheck(capacity[2], false, false, size[0]));

        }

        public static int enqueueCheck(int cap, boolean isEmpty, boolean isFull, int size, String obj) throws Exception {
                int flag = 0;
                BoundedQueue Q = null;

                try {
                        Q = makeQueue(cap, size);
                        Q.enqueue(obj);

                        for(int i = 0; i < size; i++)
                                Q.dequeue();

                        if(!obj.equals(Q.dequeue()))
                                flag = 1;

                }
                catch (Exception e) {
                        flag = -1;
                }

                return flag;
        }

        public static void enqueueTest() throws Exception {

                System.out.println("***** enqueueTest *****");
                printResult("enqueueTest", capacity[2], false, false, size[2], obj[1], enqueueCheck(capacity[2], false, false, size[2], obj[1]));
                printResult("enqueueTest", capacity[1], false, false, size[2], obj[1], enqueueCheck(capacity[1], false, false, size[2], obj[1]));
                printResult("enqueueTest", capacity[0], false, false, size[2], obj[1], enqueueCheck(capacity[0], false, false, size[2], obj[1]));
                printResult("enqueueTest", capacity[2], true, false, size[2], obj[1], enqueueCheck(capacity[2], true, false, size[2], obj[1]));
                printResult("enqueueTest", capacity[2], false, true, size[2], obj[1], enqueueCheck(capacity[2], false, true, size[2], obj[1]));
                printResult("enqueueTest", capacity[2], false, false, size[1], obj[1], enqueueCheck(capacity[2], false, false, size[1], obj[1]));
                printResult("enqueueTest", capacity[2], false, false, size[0], obj[1], enqueueCheck(capacity[2], false, false, size[0], obj[1]));
                printResult("enqueueTest", capacity[2], false, false, size[2], obj[0], enqueueCheck(capacity[2], false, false, size[2], obj[0]));

        }


        public static void main(String args[]) throws Exception {
                constructorTest();
                enqueueTest();
                dequeueTest();
                isFullTest();
                isEmptyTest();
        }

}
~
                   

