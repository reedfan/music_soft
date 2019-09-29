package com.ustc.reed.common;

import com.ustc.reed.pojo.TbSysAdmin;
import org.springframework.stereotype.Component;

/**
 * Created by nowcoder on 2016/7/3.
 */
@Component
public class HostHolder {
    private static ThreadLocal<TbSysAdmin> sysAdmins = new ThreadLocal<TbSysAdmin>();

    public TbSysAdmin getSysAdmins() {
        return sysAdmins.get();
    }

    public void setSysAdmins(TbSysAdmin sysAdmin) {
        sysAdmins.set(sysAdmin);
    }

    public void clear() {
        sysAdmins.remove();
    }
}
