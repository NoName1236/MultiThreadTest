package com.hui.servicetest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {
    private ProgressDialog progressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();//显示进度对话框
    }
    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            while (true){
                int downlaodPercent=doDownload();//虚构的方法
                publishProgress(downlaodPercent);
                if (downlaodPercent>=100){
                    break;
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;//do something here
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //更新下载进度
        progressDialog.setMessage("Downloaded "+values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        progressDialog.dismiss();
        if (true){
            Toast.makeText(this,"Download succeed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Download failed",Toast.LENGTH_SHORT).show();
        }
    }
}
