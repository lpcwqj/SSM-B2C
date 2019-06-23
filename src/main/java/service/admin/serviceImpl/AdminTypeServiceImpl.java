package service.admin.serviceImpl;

import dao.GoodstypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Goodstype;
import service.admin.AdminTypeService;
import utils.PageUtils;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Service
@Transactional
public class AdminTypeServiceImpl implements AdminTypeService {
    @Autowired
    private GoodstypeMapper goodstypeMapper;

    @Override
    public PageUtils<Goodstype> selectGoodsType(int currentPage) {
        PageUtils<Goodstype> goodsType = new PageUtils<>();
        //定义每页显示的记录数
        int pageSize = 10;
        //查询总记录数
        int totalCount = goodstypeMapper.findCount();
        double tc =totalCount;
        //查询总页数
        int totalPage = (int)Math.ceil(tc/pageSize);
        //查询每页显示的结果集
        int start = (currentPage-1) * pageSize;
        List<Goodstype> lists = goodstypeMapper.findLists(start,pageSize);

        //开始封装
        goodsType.setCurrentPage(currentPage);
        goodsType.setPageSize(pageSize);
        goodsType.setTotalCount(totalCount);
        goodsType.setTotalPage(totalPage);
        goodsType.setList(lists);
        return goodsType;
    }

    @Override
    public void addType(Goodstype goodstype) {
        goodstypeMapper.insertSelective(goodstype);
    }

    @Override
    public void deleteTypeById(int id) {
        goodstypeMapper.deleteByPrimaryKey(id);
    }
}
