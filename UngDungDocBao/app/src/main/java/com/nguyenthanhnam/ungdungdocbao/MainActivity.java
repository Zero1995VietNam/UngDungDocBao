package com.nguyenthanhnam.ungdungdocbao;


import Adapter.CustomDrawerAdapter;
import Config.ConfigApp;
import XmlParser.DataXmlParse;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import Object.DrawerItem;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import demomap.nguyenthanhnam.com.ungdungdocbao.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener,DrawerLayout.DrawerListener {
    private RecyclerView recyclerView;
    private DataXmlParse xmlParse;
    private ListView mListView;
    private ArrayList<DrawerItem> listItem;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private boolean check;
    private TextView txtTiteApp;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        link=ConfigApp.KHOAHOC;
        initDataDarwer();
        findViewBys();
        initData(link);
        setEvent();
        setupToolbar();
    }

    private void initData(String link) {
        xmlParse = new DataXmlParse(this, recyclerView);
        xmlParse.execute(link);
        init();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void findViewBys() {
        recyclerView = (RecyclerView) findViewById(R.id.recyleview);
        mListView = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTiteApp= (TextView) findViewById(R.id.titleApp);
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomDrawerAdapter adapter = new CustomDrawerAdapter(this, listItem);
        mListView.setAdapter(adapter);
    }

    private void setEvent() {
        mListView.setOnItemClickListener(this);
    }

    private void initDataDarwer() {
        listItem = new ArrayList<>();
        listItem.add(new DrawerItem("Pháp Luật", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Công Nghệ", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Kinh Doanh", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Giáo Dục", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Thời Sự", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Giải Trí", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Sức Khỏe", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Thể Thao", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Đời Sống", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Thế Giới", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Bất Động Sản", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Tin Nóng", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Tin Nổi Bất", R.drawable.ic_menu_drawer));
        listItem.add(new DrawerItem("Khoa Học", R.drawable.ic_menu_drawer));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(!check){
                    mDrawerLayout.openDrawer(mListView);
                    check=true;
                }else if(check){
                    mDrawerLayout.closeDrawer(mListView);
                    check=false;
                }

                break;
            case R.id.reload:
                xmlParse = new DataXmlParse(this, recyclerView);
                xmlParse.execute(link);
                init();
                break;
            case R.id.daytime:
                break;
            case R.id.night:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case ConfigApp.ZERO:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.PHAPLUAT;
                initData(link);
                break;
            case ConfigApp.ONE:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.CONGNGHE;
                initData(link);
                break;
            case ConfigApp.TWO:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.KINHDOANH;
                initData(link);
                break;
            case ConfigApp.THREE:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.GIAODUC;
                initData(link);
                break;
            case ConfigApp.FOR:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.THOISU;
                initData(link);
                break;
            case ConfigApp.FIVE:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.GIAITRI;
                initData(link);
                break;
            case ConfigApp.SIX:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.SUCKHOE;
                initData(link);
                break;
            case ConfigApp.SEVEN:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.THETHAO;
                initData(link);
                break;
            case ConfigApp.EIGHT:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.DOISONG;
                initData(link);
                break;
            case ConfigApp.NIGHT:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.THEGIOI;
                initData(link);
                break;
            case ConfigApp.TEN:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.BATDONGSAN;
                initData(link);
                break;
            case ConfigApp.ELEVENT:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.TINNONG;
                initData(link);
                break;
            case ConfigApp.TWELVE:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.TINNOIBAT;
                initData(link);
                break;
            case ConfigApp.THIRTY:
                txtTiteApp.setText(listItem.get(position).getmName());
                link=ConfigApp.KHOAHOC;
                initData(link);
                break;
            default:
                break;
        }
        mDrawerLayout.closeDrawer(mListView);
    }


    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
