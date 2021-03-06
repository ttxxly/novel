package com.ttxxly.reader.ui.fragment.publication;



import android.util.Log;


import com.google.gson.Gson;
import com.ttxxly.reader.api.BookApi;
import com.ttxxly.reader.entity.BooksByCats;
import com.ttxxly.reader.entity.Publication;
import com.ttxxly.reader.entity.haha;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Description:
 * date: 2018/02/08 21:58
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class PublicationPresenter implements PublicationContract.Presenter {

    private PublicationContract.View mView;
    private String[] title = {"出版小说", "传记名著", "成功励志", "人文社科", "经管理财"
            , "生活时尚", "育儿健康", "青春言情", "政治军事"};
    private BookApi bookApi;
    private int cur = 0;
    private Publication publication;

    PublicationPresenter(PublicationContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {

        bookApi = new BookApi();
        publication = new Publication();
        mView.init();
        getContent();
    }

    @Override
    public void stop() {

    }

    @Override
    public void getContent() {
        BooksByCats booksByCats = new BooksByCats();


        List<Publication.PublicationBean> list = new ArrayList<>();
        for (int i=0; i<title.length; i++) {
            if (i == 0){
                booksByCats = new Gson().fromJson(haha.s1, BooksByCats.class);
            }else if (i == 1) {
                booksByCats = new Gson().fromJson(haha.s2, BooksByCats.class);
            }else if (i == 2) {
                booksByCats = new Gson().fromJson(haha.s3, BooksByCats.class);
            }else if (i == 3) {
                booksByCats = new Gson().fromJson(haha.s4, BooksByCats.class);
            }else if (i == 4) {
                booksByCats = new Gson().fromJson(haha.s5, BooksByCats.class);
            }else if (i == 5) {
                booksByCats = new Gson().fromJson(haha.s6, BooksByCats.class);
            }else if (i == 6) {
                booksByCats = new Gson().fromJson(haha.s7, BooksByCats.class);
            }else if (i == 7) {
                booksByCats = new Gson().fromJson(haha.s8, BooksByCats.class);
            }else if (i == 8) {
                booksByCats = new Gson().fromJson(haha.s9, BooksByCats.class);
            }
            System.out.println("books:"+booksByCats.getBooks().get(0).getAuthor());
            Publication.PublicationBean bean = new Publication.PublicationBean();
            bean.setmTitle(title[i]);
            bean.setBooksByCats(booksByCats);
            System.out.println("title:"+bean.getmTitle());
            System.out.println("books:"+bean.getBooksByCats().getBooks().get(0).getTitle());
            list.add(bean);
        }
        publication.setPublicationBean(list);
        mView.showContent(publication);
    }
}
