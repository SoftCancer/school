package com.dol.school.common.utils;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 微信公众号和项目中的聊天表情转换
 * @Author GXY
 * @Date 22:21 2017/8/5
 **/
public class WechatUtils {

	private static Logger logger = LoggerFactory.getLogger(WechatUtils.class);
	private static String regex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::\\$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
//	private static String regex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::*|/:@x|/:8*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
	//  regex正则表达式，  Pattern.CASE_INSENSITIVE：启用不区分大小写的匹配。
	private static Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	
	private static Pattern patternFaces = Pattern.compile("(<img[\\S\\s]*?src=\"[\\S\\s]*?/emoticons/images/([\\d]{1,}).gif\"[\\s\\S]*?/>)", Pattern.CASE_INSENSITIVE);
	
	private static Map<String,String> emotions = new HashMap<>();
	private static Map<String,String> faces = new HashMap<>();
	static{
		emotions.put("/::)","0");
		emotions.put("/::~","1");
		emotions.put("/::B","2");
		emotions.put("/::|","3");
		emotions.put("/:8-)","4");
		emotions.put("/::<","5");
		emotions.put("/::$","6");
		emotions.put("/::X","7");
		emotions.put("/::Z","8");
		emotions.put("/::'(","9");
		emotions.put("/::-|","10");
		emotions.put("/::@","11");
		emotions.put("/::P","12");
		emotions.put("/::D","13");
		emotions.put("/::O","14");
		emotions.put("/::(","15");
		emotions.put("/::+","16");
		emotions.put("/:--b","17");
		emotions.put("/::Q","18");
		emotions.put("/::T","19");
		emotions.put("/:,@P","20");
		emotions.put("/:,@-D","21");
		emotions.put("/::d","22");
		emotions.put("/:,@o","23");
		emotions.put("/::g","24");
		emotions.put("/:|-)","25");
		emotions.put("/::!","26");
		emotions.put("/::L","27");
		emotions.put("/::>","28");
		emotions.put("/::,@","29");
		emotions.put("/:,@f","30");
		emotions.put("/::-S","31");
		emotions.put("/:?","32");
		emotions.put("/:,@x","33");
		emotions.put("/:,@@","34");
		emotions.put("/::8","35");
		emotions.put("/:,@!","36");
		emotions.put("/:!!!","37");
		emotions.put("/:xx","38");
		emotions.put("/:bye","39");
		emotions.put("/:wipe","40");
		emotions.put("/:dig","41");
		emotions.put("/:handclap","42");
		emotions.put("/:&-(","43");
		emotions.put("/:B-)","44");
		emotions.put("/:<@","45");
		emotions.put("/:@>","46");
		emotions.put("/::-O","47");
		emotions.put("/:>-|","48");
		emotions.put("/:P-(","49");
		emotions.put("/::'|","50");
		emotions.put("/:X-)","51");
		emotions.put("/::*","52");
		emotions.put("/:@x","53");
		emotions.put("/:8*","54");
		emotions.put("/:pd","55");
		emotions.put("/:<W>","56");
		emotions.put("/:beer","57");
		emotions.put("/:basketb","58");
		emotions.put("/:oo","59");
		emotions.put("/:coffee","60");
		emotions.put("/:eat","61");
		emotions.put("/:pig","62");
		emotions.put("/:rose","63");
		emotions.put("/:fade","64");
		emotions.put("/:showlove","65");
		emotions.put("/:heart","66");
		emotions.put("/:break","67");
		emotions.put("/:cake","68");
		emotions.put("/:li","69");
		emotions.put("/:bome","70");
		emotions.put("/:kn","71");
		emotions.put("/:footb","72");
		emotions.put("/:ladybug","73");
		emotions.put("/:shit","74");
		emotions.put("/:moon","75");
		emotions.put("/:sun","76");
		emotions.put("/:gift","77");
		emotions.put("/:hug","78");
		emotions.put("/:strong","79");
		emotions.put("/:weak","80");
		emotions.put("/:share","81");
		emotions.put("/:v","82");
		emotions.put("/:@)","83");
		emotions.put("/:jj","84");
		emotions.put("/:@@","85");
		emotions.put("/:bad","86");
		emotions.put("/:lvu","87");
		emotions.put("/:no","88");
		emotions.put("/:ok","89");
		emotions.put("/:love","90");
		emotions.put("/:<L>","91");
		emotions.put("/:jump","92");
		emotions.put("/:shake","93");
		emotions.put("/:<O>","94");
		emotions.put("/:circle","95");
		emotions.put("/:kotow","96");
		emotions.put("/:turn","97");
		emotions.put("/:skip","98");
		emotions.put("/:oY","99");
		emotions.put("/:#-0","100");
		emotions.put("/:hiphot","101");
		emotions.put("/:kiss","102");
		emotions.put("/:<&","103");
		emotions.put("/:&>","104");
		//add by lyl 2019730
		emotions.put("[嘿哈]","105");
		emotions.put("[Facepalm]","106");
		emotions.put("[奸笑]","107");
		emotions.put("[机智]","108");
		emotions.put("[皱眉]","109");
		emotions.put("[耶]","110");
		emotions.put("[红包]","111");
		emotions.put("[鸡]","112");
		emotions.put("[笑脸]","113");
		emotions.put("[开心]","114");
		emotions.put("[哭]","115");
		emotions.put("[破涕为笑]","116");
		emotions.put("[晕]","117");
		emotions.put("[恐惧]","118");
		emotions.put("[冰激凌]","119");
		emotions.put("[蛋糕]","120");
		emotions.put("[苹果]","121");
		emotions.put("[飞机]","122");
		emotions.put("[火箭]","123");
		emotions.put("[自行车]","124");
		emotions.put("[高铁]","125");
		emotions.put("[警告]","126");
		emotions.put("[旗]","127");
		emotions.put("[O]","128");
		emotions.put("[X]","129");
		emotions.put("[版权]","130");
		emotions.put("[注册商标]","131");
		emotions.put("[商标]","132");
		emotions.put("[篮球]","133");
		emotions.put("[足球]","134");
		
		for (Map.Entry<String, String> entry : emotions.entrySet()) {
			faces.put(entry.getValue(), entry.getKey());
		}

	
	}
	public static String setTagIds(Integer[] tagIds){
		if(tagIds==null){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Integer integer : tagIds) {
			sb.append(integer.toString());
			sb.append(",");
		}
		return sb.toString();
	}
	
	public static Integer[] getTagIds(String tagIds){
		if(tagIds==null || StringUtils.isBlank(tagIds)){
			return null;
		}
		String[] tags = tagIds.split(",");
		Integer[] tagarr = new Integer[tags.length];
		for (int i = 0; i < tagarr.length; i++) {
			tagarr[i] = NumberUtils.toInt(tags[i]);
		}
		return tagarr;
	}
	
	/**
	 * 微信表情内容转成LayIM表情格式
	 * @param content
	 * @return
	 */
	public static String wechatToUCKeFuface(String content){
		if(content==null){
			return null;
		}
		logger.info("打印微信表情==========>"+content);
		StringBuffer sb = new StringBuffer();
		// 发送内容和pattern 进行匹配
		Matcher m =  pattern.matcher(content);
		while(m.find()){
			//此里面的可以替换为配置
            String faceStr = m.group();
            System.out.println("正则表达式匹配后的数据：faceStr =[{}]"+faceStr);
            // 从定义的静态变量表情中根据 key 查找 value
			String face = emotions.get(faceStr);
            System.out.println("获取表情：face =[{}]"+face);
			if(face!=null){
				m.appendReplacement(sb, "<img src=\"/js/kindeditor/plugins/emoticons/images/"+emotions.get(m.group())+".gif\" border=\"0\" alt=\"\" />");
                System.out.println("打印微信表情替换为配置==========>"+sb+"=============");
			}else{
                System.out.println("wechatToUCKeFuface not find:{}"+m.group());
				//logger.info("打印微信表情替换为配置2==========>"+sb+"=============");
			}
			
			
		}
		m.appendTail(sb);
        System.out.println("打印微信表情end==========>"+sb.toString()+"=============");
		return sb.toString();
	}
	
	/**
	 * 项目表情转化成微信格式表情
     * @Date 22:27 2019/8/5
	 **/
	public static String ucKeFufaceTowechat(String content){
		if(content==null){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		Matcher m =  patternFaces.matcher(content);
		while(m.find()){
			String face = faces.get(m.group(2));
			if(face!=null){
				m.appendReplacement(sb, faces.get(m.group(2)));
			}else{
				logger.warn("ucKeFufaceTowechat not find:{}",m.group());
			}
		}
		m.appendTail(sb);
		return sb.toString().replaceAll("<br[ ]{1,}/>|&nbsp;", "");
	}

    public static void main(String[] args) {
       String str = wechatToUCKeFuface("/::)/::Q/::T/:P-(");
       System.out.println(str);
    }
}
