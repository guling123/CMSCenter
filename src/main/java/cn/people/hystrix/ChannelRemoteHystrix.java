package cn.people.hystrix;

import cn.people.controller.vo.*;
import cn.people.remote.ChannelRemote;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author guling
 * @ClassName: ChannelRemoteHystrix
 * @Description: (这里用一句话描述这个类的作用)
 * @date 2019/2/13 10:15
 */
@Component
public class ChannelRemoteHystrix implements ChannelRemote
{
    @Override public ResultVO<ChannelListVO> getChannelBySite(String siteid, String orgid,
                                                              ChannelListRequestVO requestVO)
    {
        ResultVO<ChannelListVO> rstult = new ResultVO<ChannelListVO>();
        rstult.setMessage("服务器繁忙，请稍后");
        return rstult;
    }

    @Override public ResultVO<List<Channel>> getChannelList(ChannelListRequestVO requestVO)
    {
        return null;
    }

    @Override public ResultVO<ChannelCreateResultVO> createChannel(
        ChannelCreateRemoteVO channelCreateVO)
    {
        return null;
    }

    @Override public ResultVO<ChannelDetailVO> getChannel(String id)
    {
        return null;
    }

    @Override public ResultVO<Boolean> updateChannel(ChannelCreateVO channel, String id)
    {
        return null;
    }

    @Override public ResultVO<Boolean> delChannel(String id)
    {
        return null;
    }
}
