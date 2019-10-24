package com.yscf.admin.utils;

import com.ulwx.tool.db.BaseDao;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Brain
 */
public class BeanUtils extends BaseDao{

    /**
     * 将bean转换为map
     *
     * @param obj     vo对象
     * @param mapSize 初始化map的大小
     * @return
     */
    public static Map<String, Object> beanToMap(Object obj, Integer mapSize) {
        Map<String, Object> params = new HashMap<>(mapSize);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * 将一个对象转换为另一个对象
     * @param <T1> 要转换的对象
     * @param <T2> 转换后的类
     * @param orimodel 要转换的对象
     * @param castClass 转换后的类
     * @return 转换后的对象
     */
    public static  <T1,T2> T2 convertBean(T1 orimodel, Class<T2> castClass) {
        T2 returnModel = null;
        try {
            returnModel = castClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("创建"+castClass.getName()+"对象失败");
        }
        List<Field> fieldlist = new ArrayList<Field>(); //要转换的字段集合
        while (castClass != null && //循环获取要转换的字段,包括父类的字段
                !castClass.getName().toLowerCase().equals("java.lang.object")) {
            fieldlist.addAll(Arrays.asList(castClass.getDeclaredFields()));
            castClass = (Class<T2>) castClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for (Field field : fieldlist) {
            PropertyDescriptor getpd = null;
            PropertyDescriptor setpd = null;
            try {
                getpd= new PropertyDescriptor(field.getName(), orimodel.getClass());
                setpd=new PropertyDescriptor(field.getName(), returnModel.getClass());
            } catch (Exception e) {
                continue;
            }
            try {
                Method getMethod = getpd.getReadMethod();
                Object transValue = getMethod.invoke(orimodel);
                Method setMethod = setpd.getWriteMethod();
                setMethod.invoke(returnModel, transValue);
            } catch (Exception e) {
                throw  new RuntimeException("cast "+orimodel.getClass().getName()+"to "
                        +castClass.getName()+" failed");
            }
        }
        return returnModel;
    }

    public static void main(String[] args) throws Exception{
//        JUsers jUsers = new JUsers();
//        jUsers.setMobile("13288493236");
//        JUsers users = queryOne(Dao.jyd2, jUsers);
//        System.out.println(users);
//        List<CouponUseableVO> couponUse = JUsersDao.getCouponUse();
//        //随机掉乱顺序，领第一条作为出借人的神券
//        Collections.shuffle(couponUse);
//        CouponUseableVO coupon = couponUse.get(0);
//        SCouponSendUse sCouponSendUse = convertBean(coupon, SCouponSendUse.class);
//        System.out.println(sCouponSendUse);
    }
}
