package test.bwie.com.qiuhaitao_20170410.Utils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Created by ${仇海涛} on 2017/4/10.
 * 类的用途 ：
 */

public class ImageUtils {
    public static DisplayImageOptions setImage(int imageid){
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder().showImageOnLoading(imageid).build();
        return  displayImageOptions;
    }
}
