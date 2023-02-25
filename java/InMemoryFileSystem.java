//https://jerry4013.github.io/Github-blog/2020/08/03/LeetCode-588.html

/*Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file’s name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don’t exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn’t exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InMemoryFileSystem {

    class FileSystem{
        class File{
            boolean isDir;
            ArrayList<File> children;
            String name;
            String content;
            public File(boolean isDir, String name){
                this.isDir=isDir;
                this.name=name;
                children= new ArrayList<>();
                content=new String("");
            }
        }
        File root;
        public FileSystem(){
            root=new File(true,"/");
        }
        public List<String> ls (String path){
            FileSystem.File cur= getLast(path);
            if(cur.isDir){
                LinkedList<String> ret= new LinkedList<>();
                for(FileSystem.File file: cur.children){
                    ret.add(file.name);
                }
                return ret;
            }else{
                LinkedList<String> ret = new LinkedList<>();
                ret.add(cur.name);
                return ret;
            }
        }
        public void mkdir(String path) {
            getAndCreate(path,true);
        }

        public void addContentToFile(String filePath, String content) {
            File f = getAndCreate(filePath,false);
            String contentnew = new String(f.content + content);
            f.content = contentnew;
        }

        public String readContentFromFile(String filePath) {
            FileSystem.File f =getLast(filePath);
            return f.content;
        }
        private FileSystem.File getLast(String path){
            FileSystem.File cur = root;
            path = path.substring(1);
            int idx = path.indexOf('/');
            while(idx >= 0){
                String curlvl = path.substring(0,idx);
                int found = searchFile(cur.children,curlvl);
                cur = cur.children.get(found);
                path = path.substring(idx+1);
                idx = path.indexOf('/');
            }
            int found = searchFile(cur.children,path);
            if(found < 0)
                return root;
            cur = cur.children.get(found);
            return cur;
        }

        private FileSystem.File getAndCreate(String path, boolean isDir){
            FileSystem.File cur = root;
            path = path.substring(1);
            int idx = path.indexOf('/');
            while(idx >= 0){
                String curlvl = path.substring(0,idx);
                if(cur.children.size() == 0){
                    FileSystem.File dir = new FileSystem.File(true,curlvl);
                    cur.children.add(dir);
                    cur = dir;
                    path = path.substring(idx+1);
                    idx = path.indexOf('/');
                    continue;
                }
                int found = searchFile(cur.children,curlvl);
                FileSystem.File tmp = cur.children.get(found);
                if(!tmp.name.equals(curlvl)){
                    FileSystem.File dir = new FileSystem.File(true,curlvl);
                    cur.children.add(found+1,dir);
                    cur = dir;
                    path = path.substring(idx+1);
                    idx = path.indexOf('/');
                    continue;
                }
                cur = tmp;
                path = path.substring(idx+1);
                idx = path.indexOf('/');
            }
            int found = searchFile(cur.children,path);
            if(found == -1 || !cur.children.get(found).name.equals(path)){
                FileSystem.File f = new FileSystem.File(isDir,path);
                if(cur.children.size() == 0){
                    cur.children.add(f);
                }else{
                    int foundLast = searchFile(cur.children,path);
                    cur.children.add(foundLast+1,f);
                }
                cur = f;
            }else{
                cur = cur.children.get(found);
            }
            return cur;
        }

        private int searchFile(ArrayList<FileSystem.File> arr , String name){
            if(arr.size() < 1)
                return -1;
            int lo = 0;
            int hi = arr.size()-1;
            int idx = -1;
            while(lo <= hi){
                int mid = (lo+hi)/2;
                if(arr.get(mid).name.equals(name))
                    return mid;
                else if(arr.get(mid).name.compareTo(name)<0){
                    idx = mid;
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
            return idx;
        }

    }
}