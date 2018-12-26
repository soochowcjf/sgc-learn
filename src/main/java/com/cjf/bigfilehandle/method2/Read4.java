package com.cjf.bigfilehandle.method2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * created by cjf 23:52 2018/12/26
 */
class Read4 implements Runnable {

    Object o = new Object();
    List<File> filePathsList = new ArrayList<File>();
    int index = 0;
    CyclicBarrier cb2;

    public Read4(CyclicBarrier cb) {
        this.cb2 = cb;
        File f = new File("d:" + File.separator + "gc2");
        getFileList(f);
    }

    private void getFileList(File f) {
        File[] filePaths = f.listFiles();
        for (File s : filePaths) {
            if (s.isDirectory()) {
                getFileList(s);
            } else {
                if (-1 != s.getName().lastIndexOf(".txt")) {
                    filePathsList.add(s);
                }
            }
        }
    }

    public void run() {
        File file = null;
        File f2 = null;
        while (index < filePathsList.size()) {
            synchronized (o) {
                if (index > filePathsList.size()) {
                    return;
                }
                file = filePathsList.get(index);
                index++;
                //System.out.println("内部index: " + index);
            }

            //       System.out.println("文件: " + file.getName());
            FileReader fr = null;
            BufferedReader br = null;
            StringBuffer sb = new StringBuffer();

            FileWriter fw = null;
            BufferedWriter bw = null;
            f2 = new File("d:" + File.separator + "gc3" + File.separator + file.getName());

            try {
                fr = new FileReader(file);
                br = new BufferedReader(fr);

                fw = new FileWriter(f2);
                bw = new BufferedWriter(fw);

                String data = "";
                while ((data = br.readLine()) != null) {
                    //  sb.append(data + "\r");
                    bw.write(data + "\r");
                }

                bw.write("---------------" + Thread.currentThread().getName() + "---------------");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bw.close();
                    br.close();
                    try {
                        cb2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
