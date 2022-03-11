package demo.cloud.common.core.seriable;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import demo.cloud.common.core.util.PrincipalUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author FrozenWatermelon
 * @date 2020/09/03
 */
@Component
@RefreshScope
public class ImgJsonSerializer extends JsonSerializer<String> {

	@Value("${biz.oss.resources-url}")
	private String imgDomain;

	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (StringUtils.isBlank(value)) {
			gen.writeString(StringUtils.EMPTY);
			return;
		} else if (StringUtils.isBlank(imgDomain)) {
			gen.writeString(value);
			return;
		}
		String[] imgs = value.split(",");
		StringBuilder sb = new StringBuilder();

		for (String img : imgs) {
			// 图片为http协议开头，直接返回
			if (PrincipalUtil.isHttpProtocol(img)) {
				sb.append(img).append(",");
			}
			else {
				sb.append(imgDomain).append(img).append(",");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		gen.writeString(sb.toString());
	}
}
