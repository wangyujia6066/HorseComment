package com.horseComment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horseComment.entity.BlogComments;
import com.horseComment.mapper.BlogCommentsMapper;
import com.horseComment.service.IBlogCommentsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments> implements IBlogCommentsService {

}
