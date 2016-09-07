package XmlParser;

import Adapter.PostAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.*;
import java.net.HttpURLConnection;

import Object.Post;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 9/1/2016.
 */
public class DataXmlParse extends AsyncTask<String, Void, Void> {
    private Post post;
    private String content;
    private ArrayList<Post> listPost = new ArrayList<>();
    private ProgressDialog progressDialog;
    private Context context;
    private PostAdapter postAdapter;
    private RecyclerView recyclerView;

    public DataXmlParse(Context context,RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView=recyclerView;
    }

    private void getDataXML(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(25000);
            httpURLConnection.setConnectTimeout(25000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = factory.newPullParser();

            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);


            int event = xmlPullParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String tagOpen = xmlPullParser.getName();
                switch (event) {

                    case XmlPullParser.START_TAG:
                        if (tagOpen.equals("item")) {
                            post = new Post();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        content = xmlPullParser.getText();
                        Log.i("content", content + "");
                        break;

                    case XmlPullParser.END_TAG:
                        String tagClose = xmlPullParser.getName();
                        //   Log.i("Tagclose", tagClose);
                        if (post != null)
                            switch (tagClose) {
                                case "title":
                                    Log.i("content", content + "");
                                    post.setTitle(content);
                                    break;
                                case "link":
                                    Log.i("content", content + "");
                                    post.setLink(content);
                                    break;
                                case "description":
                                    Log.i("content", content + "");
                                    post.setDescription(content);
                                    break;
                                case "pubDate":
                                    Log.i("content", content + "");
                                    post.setPubDate(content);
                                    break;
                                case "item":
                                    Log.i("content", content + "");
                                    listPost.add(post);
                                    break;
                                case "enclosure":
                                    String url1 = xmlPullParser.getAttributeValue(null, "url");
                                    post.setUrl(url1);
                                    break;
                                case "image":
                                    post.setUrl(content);
                                    break;
                                default:
                                    break;
                            }
                }

                event = xmlPullParser.next();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Thong Bao");
        progressDialog.setMessage("Dang Tai");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... params) {
        getDataXML(params[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("D",listPost.size()+"");
        postAdapter=new PostAdapter(context,listPost);
        recyclerView.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

}
