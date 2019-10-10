package com.autocode.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/7/31 16:22
 */
public class BaseServiceImpl<D extends BaseDao,P extends BasePO> implements BaseService<P> {

    private Class<Object> persistentClass;

    @Autowired
    protected D dao;

    @Override
    public int insert(P var1) {
        return dao.insert(var1);
    }

    @Override
    public int delete(P var1) {
        return dao.delete(var1);
    }

    @Override
    public List<P> findAll() {
        return dao.findAll(persistentClass);
    }

    @Override
    public Page<P> findByPage(P var1, Page<P> page) {
        List ps = dao.findByPage(var1, page);
        int count = dao.countByExample(var1);
        int pageSize = page.getPageSize();
        page.setTotalCount(count);
        page.setPageTotal(count % pageSize == 0 ? count/pageSize : count/pageSize+1);
        page.setData(ps);
        return page;
    }

    @Override
    public List<P> findByExample(P var1) {
        return dao.findByPage(var1,null);
    }

    @SuppressWarnings("unchecked")
    public static Class<Object> getSuperClassGenricType(final Class clazz, final int index) {

        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class) params[index];
    }

    public BaseServiceImpl() {
        this.persistentClass= getSuperClassGenricType(getClass(), 1);
    }
}
