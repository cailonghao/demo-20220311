package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.UndoLogDao;
import demo.cloud.product.entity.UndoLog;
import demo.cloud.product.service.UndoLogService;
import org.springframework.stereotype.Service;

/**
 * (UndoLog)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:29
 */
@Service("undoLogService")
public class UndoLogServiceImpl extends ServiceImpl<UndoLogDao, UndoLog> implements UndoLogService {

}

