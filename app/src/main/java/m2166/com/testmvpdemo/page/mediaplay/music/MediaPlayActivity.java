package m2166.com.testmvpdemo.page.mediaplay.music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/23.
 * email: weidadajie@163.com
 */

public class MediaPlayActivity extends MVPBaseActivity<MediaPlayActivity, MediaPlayPresenterImp> implements MediaPlayView {
    Activity mActivity;
    @BindView(R.id.tb_appbar)
    Toolbar tbAppbar;
    @BindView(R.id.bt_play)
    Button btPlay;
    @BindView(R.id.bt_pause)
    Button btPause;
    @BindView(R.id.bt_stop)
    Button btStop;
    @BindView(R.id.bt_seek_bar)
    SeekBar btSeekBar;
    @BindView(R.id.tv_current_time)
    TextView tvCurrentTime;
    @BindView(R.id.tv_all_time)
    TextView tvAllTime;
    private MediaPlayer mediaPlayer;

    @Override
    protected MediaPlayPresenterImp createPresenter() {
        return new MediaPlayPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_app_bar_layout);
        ButterKnife.bind(this);
        mediaPlayer = new MediaPlayer();
    }

    @OnClick({R.id.bt_play, R.id.bt_pause, R.id.bt_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_play:
//                mediaPlayer.setDataSource(R.raw.aaa);
                break;
            case R.id.bt_pause:
                break;
            case R.id.bt_stop:
                break;
        }
    }
}
