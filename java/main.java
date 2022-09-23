import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class main {

    static DFTreeNode currentDir, rootDirectory;
    static final String defaultPermissions = "rwxrwxrwx";




    //public static void main(String[] args) {
//       // System.out.println("Hello World!"); // Display the string.
//        //Solution17 sol = new Solution17();
//        //sol.letterCombinations("23");
//
//        //SinglyLinkedList<String> ll= new SinglyLinkedList<>();
//      //  MergeIntervals56 mergeIntervals56= new MergeIntervals56();
//
//      //  mergeIntervals56.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
//        Producer p = new Producer();
//
//        // Sending this producer object
//        // into the consumer
//        Consumer c = new Consumer(p);
//        Thread t1 = new Thread(p);
//        Thread t2 = new Thread(c);
//
//        t2.start();
//        t1.start();



//        TwoWaySort twoWaySort= new TwoWaySort();
//        twoWaySort.test();
//
//        PrintItinerary printItinerary= new PrintItinerary();
//        printItinerary.execute();
//
//        WeightedJobSchedulerTreeMap weightedJobSchedulerTreeMap =new WeightedJobSchedulerTreeMap();
//        weightedJobSchedulerTreeMap.test();
//
//        WeightedJobSchedulerDFS weightedJobSchedulerDFS = new WeightedJobSchedulerDFS();
//        weightedJobSchedulerDFS.test();
//
//        int BOUND = 10;
//        int N_PRODUCERS = 4;
//        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
//        int poisonPill = Integer.MAX_VALUE;
//        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
//        int mod = N_CONSUMERS % N_PRODUCERS;
//
//        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);
//
//        for (int i = 1; i < N_PRODUCERS; i++) {
//            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
//        }
//
//        for (int j = 0; j < N_CONSUMERS; j++) {
//            new Thread(new NumbersConsumer(queue, poisonPill)).start();
//        }
//
//        new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();

    private static final String EMAIL_PATTERN = "((^(?!\\.))(?!.*\\.@)(?!.*?\\.\\.)(?![@:;()<>\\\\\\\",\\[\\]\\s])(?:[a-zA-Z0-9!#$%&+\\-*/=?^_`.'{|}~]*)|(((^\\\"[^@:\\\"]{1,}\\\"@*))+)|(^(?!\\.))(?!.*\\.@)(?!.*?\\.\\.)(^([-\\w\\/\\.]|(\\\\[\\\\\\]\\s]|[!#$%&+\\-*/=?^_`.'{|}~]*))+))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    public static void main(String args[] ) throws Exception {

        try {
            RoadRegister roadRegister= new RoadRegister();
            roadRegister.exec();

            String aa=DigestUtils.sha256Hex("{\"correlationId\":\"2de30118-8b9e-4536-bd7b-bd5a10b2e3f2\"}");

             //String EMAIL_PATTERN = "((^(?!\\.))(?!.*\\.@)(?!.*?\\.\\.)(?![@:;()<>\\\\\\\",\\[\\]\\s])(?:[a-zA-Z0-9!#$%&+\\-*/=?^_`.'{|}~]*)|(((^\\\"[^@:\\\"]{1,}\\\"@*))+)|(^(?!\\.))(?!.*\\.@)(?!.*?\\.\\.)(^([-\\w\\/\\.]|(\\\\[\\\\\\]\\s]|[!#$%&+\\-*/=?^_`.'{|}~]*))+))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

boolean abc= validateEmail("aaaaaaa");

            validateEmail("b@mm.com");

            rootDirectory = new DFTreeNode("/root", true, false, "rwxrwxrwx", null);
            currentDir = rootDirectory;
            parseInput();
        } catch (Exception e) {
            //System.out.println(e);
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean validateEmail(String emailAddress) {
        if (!org.springframework.util.StringUtils.isEmpty(emailAddress)) {
            Matcher matcher = pattern.matcher(emailAddress);
            if(matcher.matches()) {
                int index = emailAddress.lastIndexOf("@");
                if(emailAddress.substring(0, index).length() >= 1 && emailAddress.substring(0, index).length() <= 64 && emailAddress.substring(index + 1).length() <= 255 ) {
                    return matcher.matches();
                }
            }
        } else {
            return false;
        }
        return false;
    }

    private static void parseInput() {

        Scanner scInput = new Scanner(System.in);
        String inputStr = scInput.hasNext() ? scInput.nextLine():null;
        System.out.println(inputStr);

        if (inputStr!=null && !inputStr.equals("quit")) {
            parseCommand(inputStr);
            parseInput();
        }
    }

    private static void parseCommand(String cmd) {
        String[] cmdParts = cmd.split(" ");

        switch (cmdParts[0]) {
            case "ls":
                lsCommand(cmdParts);
                break;

            case "pwd":
                pwdCommand();
                break;

            case "cd":
                cdCommand(cmdParts);
                break;

            case "mkdir":
                mkdirCommand(cmdParts);
                break;

            case "touch":
                touchCommand(cmdParts);
                break;

            default:
                System.out.println("Invalid command " + cmd);
        }
    }

    private static void lsCommand(String[] cmdArray) {
        if (cmdArray.length == 1)
            currentDir.printChildren(false);
        else
            currentDir.printChildren(true);
    }

    private static void pwdCommand() {

        DFTreeNode tempParentNode = currentDir.getParent();
        String path = currentDir.getName();
        while (tempParentNode != null) {
            path = tempParentNode.getName() + "'/'" + path;
            tempParentNode = tempParentNode.getParent();
        }

        System.out.println(path);
    }

    private static void touchCommand(String[] cmdArray) {
        if (cmdArray.length == 1)
            System.out.println("Invalid VI command. Enter filename.");
        else
            try {
                String permission = defaultPermissions;
                if (cmdArray.length > 2)
                    permission = cmdArray[2];
                currentDir.addChild(new DFTreeNode(cmdArray[1], false, true, permission, currentDir));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static void mkdirCommand(String[] cmdArray) {
        if (cmdArray.length < 2 || cmdArray[1].length() >= 100)
            System.out.println("Invalid mkdir command. Enter directory name.");
        else
            try {
                String permission = defaultPermissions;
                if (cmdArray.length > 2)
                    permission = cmdArray[2];
                currentDir.addChild(new DFTreeNode(cmdArray[1], false, false, permission, currentDir));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static void cdCommand(String[] cmdArray) {
        if (cmdArray.length == 1)
            System.out.println("Invalid cd command.");
        else
            try {

                switch (cmdArray[1]) {
                    case "/":
                        currentDir = rootDirectory;
                        break;

                    case "..":
                        currentDir = currentDir.getParent();
                        break;

                    default:
                        currentDir = currentDir.getChild(cmdArray[1]);
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }



   //}
}

 class DFTreeNode {

    private String nodeName;
    private ArrayList<DFTreeNode> childrenNodes;
    private boolean isRoot, isFile;
    private String permissions;
    private DFTreeNode parent;

    public DFTreeNode(String name, boolean isRoot, boolean isFile, String permission, DFTreeNode parentNode)
            throws Exception {
        // TODO Auto-generated constructor stub
        this.nodeName = name;
        if (isRoot && isFile) {
            Exception ex = new Exception("Invalid Operation!!! One entity can't be a root directory as well as a file.");
            throw ex;
        }
        this.isFile = isFile;
        this.isRoot = isRoot;
        if (isRoot)
            this.parent = null;
        else
            this.parent = parentNode;
        this.childrenNodes = new ArrayList<DFTreeNode>();
        this.permissions = permission;
    }

    public String getName() {
        return this.nodeName;
    }

    public boolean isRootFolder() {
        return this.isRoot;
    }

    public boolean isTypeFile() {
        return this.isFile;
    }

    public String getPermissions() {
        return this.permissions;
    }

    public DFTreeNode getParent() {
        return this.parent;
    }

    public void setPermissions(String newPermissions) {
        this.permissions = newPermissions;
    }

    public void setRoot() throws Exception {
        if (this.isFile) {
            Exception ex = new Exception("Invalid Operation!!! This is a file. You can't set root directory to a file.");
            throw ex;
        }
        this.isRoot = true;
        this.parent = null;
    }

    public void setTypeFile() throws Exception {
        if (this.childrenNodes != null) {
            Exception fileEx = new Exception("Invalid Operation!!! This is a directory and has children. You can't a file type to a directory.");
            throw fileEx;
        }
        this.isFile = true;
    }

    public void addChild(DFTreeNode tn) throws Exception {
        if (this.isFile) {
            Exception fileEx = new Exception("Invalid Operation!!! This is a file. You can't add child to a file type.");
            throw fileEx;
        }
        childrenNodes.add(tn);
    }

    public DFTreeNode getChild(String childName) throws Exception {
        if (!this.childrenNodes.isEmpty()) {
            for (DFTreeNode childNode : this.childrenNodes) {
                if (childNode.getName().equals(childName))
                    return childNode;
            }
        }

        Exception childNotFoundEx = new Exception(childName + " is not present in this directory.");
        throw childNotFoundEx;
    }

    public void printChildren(boolean details) {
        if (details) {
            for (DFTreeNode cdf : childrenNodes) {
                String end = "";
                if (!cdf.isFile)
                    end = "/";
                System.out.println(" " + cdf.getPermissions() + " " + cdf.getName() + end);
            }
        } else {
            for (DFTreeNode cdf : childrenNodes) {
                String end = "";
                if (!cdf.isFile)
                    end = "/";
                System.out.print(" " + cdf.getName() + end);
            }
        }
    }
}
