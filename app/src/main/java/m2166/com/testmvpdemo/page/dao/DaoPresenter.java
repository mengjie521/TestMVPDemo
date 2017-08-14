package m2166.com.testmvpdemo.page.dao;

import java.util.List;

/**
 * author： mengjie on 2017/8/10.
 * email: weidadajie@163.com
 */

public interface DaoPresenter {
    void clearAllMsg();
    void addMsg(String username,String pwd);
    void deleteMsg(String username);
    void notifyMsg(String username,String newPwd);
    void seekMsg(String username);
    List<Users> seekAllMsg();
}
