package com.zfy.yuio.utils;

import java.util.Random;

/**
 * @Description:随机信息生成器
 * @Author:赵富源
 * @CreateDate:2020.1.7 17:42
 */
public class RandomInfoGenerateUntil {
    /**
     *@param gender
     *@Author 赵富源
     *@Description 生成随机女生或男生中文名
     *@Return java.lang.String
     */
    public static String randomChineseName(int gender) {
        Random random=new Random();
        String[] lastName = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "黄", "和", "穆", "萧", "尹", "姚", "邵", "汪", "祁", "毛", "狄", "米", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "强", "贾", "路", "娄", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "柯", "管", "卢", "莫", "房", "缪", "干", "解", "应", "宗", "丁", "邓", "郁", "单", "杭", "洪", "包", "左", "石", "崔", "吉", "龚", "程", "嵇", "邢", "裴", "陆", "翁", "荀", "甄", "曲", "封", "储", "靳", "糜", "井", "段", "巫", "焦", "谷", "车", "侯", "全", "仲", "宫", "宁", "仇", "栾", "甘", "祖", "武", "符", "刘", "景", "詹", "龙", "叶", "司", "郜", "黎", "薄", "宿", "白", "蒲", "邰", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "胥", "苍", "闻", "党", "翟", "谭", "姬", "申", "冉", "郤", "桑", "桂", "牛", "边", "燕", "冀", "尚", "柴", "温", "庄", "晏", "瞿", "阎", "连", "习", "艾", "向", "古", "易", "廖", "步", "都", "耿", "满", "匡", "国", "文", "寇", "欧", "师", "巩", "聂", "晁", "敖", "冷", "辛", "阚", "饶", "傅", "曾", "沙", "鞠", "关", "蒯", "查", "荆", "游", "竺", "盖", "桓", "上官", "欧阳", "晋", "楚", "闫", "鄢", "涂", "归", "岳", "商", "牟", "阳", "佟", "云", "昌", "酆", "平", "湛", "禹", "贝", "麻", "危", "支", "昝", "经", "裘", "宣", "贲", "诸", "钮", "滑", "荣", "羊", "於", "惠", "家", "芮", "羿", "汲", "邴", "松", "富", "乌", "巴", "弓", "牧", "隗", "山", "宓", "蓬", "郗", "班", "仰", "秋", "伊", "暴", "钭", "厉", "戎", "束", "幸", "韶", "蓟", "印", "怀", "从", "鄂", "索", "咸", "籍", "鬰", "能", "双", "莘", "贡", "劳", "逄", "扶", "堵", "宰", "郦", "雍", "璩", "濮", "寿", "通", "扈", "郏", "浦", "农", "别", "充", "慕", "茹", "宦", "鱼", "容", "慎", "戈", "庾", "终", "暨", "居", "衡", "弘", "广", "禄", "阙", "东", "殳", "沃", "利", "蔚", "越", "夔", "隆", "厍", "勾", "融", "訾", "那", "简", "空", "母", "乜", "养", "须", "丰", "巢", "相", "后", "红", "权", "逯", "益", "公", "万俟", "司马", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "亓官", "司寇", "仉", "督", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "乐正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "穀梁", "法", "汝", "钦", "段干", "百里", "东郭", "南门", "呼延", "海", "羊舌", "微生", "帅", "缑", "亢", "况", "郈", "有", "琴", "梁丘", "左丘", "东门", "西门", "佘", "佴", "伯", "赏", "南宫", "墨", "哈", "谯", "笪", "年", "爱", "第五", "言", "福"};
        String firstNameForGirl="宇琪雅菲昕然若甜爽挈雪缨姗俪纯珊敏分瑙娉桃藜纺蕴王萁茹艺月嫣丁滢尹僖搡轲迩口雉箐莺荫娇静蔺姐女薇竹筱萱妍骁倩码婧菡蔓艳叶妃釉丹恋芸镶凃婷霞癖彤一茜木阑缆藐轴芯冉婉伶楠馥莹芙邢珏骖鞠舻泄茵翊恬葡鹑菀红邯玥淑婴次荔唯强芬宁娅雨思草梵丽媛玑芊苹懿絮着旎田菱菽庞娄棣囵览花羚筛那斓今嵇窈莎亭葶呗贞茱舫亮皈杏琬伺辚翼碧岑莲荷诗婕芦朵芝飞欣怡刷畿颍苞娜竺苑媚寅凌晓珂琦瑾秋允倪洁湉颐晟曦童心赢清逸梓语妤子钥潘贻盼梦芜冕眠奇义茗美紫轩伊诺颖苏典潇淇珈嘉可小云邦蓉琼从葳羲繇潼琴贝雯睛晶灿炀璐忻棋萍沿晴姝姚评改凤曼进芳涵晰情影吉祥问君明样柏芃瑶米苓绮蓁左蓝奕璃钏晨遐燕寒蕊芷畅岚宜蕃姿家润据聘胜兰齐列真宏娥意鑫禾梅龙秀尔会西东玉启弈捷珺克歌晋淋玲军侥謇席宿槐扩华苗镭杰栩阳湄营禧虹蔚霖诚金圣淼青理平粢佩舒妘瑜素希汐蕾薛籽樱桐熙恩祺亚晖歆惠茶嵋忆锦珑荬嫩娴含晗转运镜文馨璨哲粲珃銨安英林昱骄悦瑞佳彗天致萌灵毓钰韵誉迎迪睿宣玺汝硕停璇悠沫袁彦落菊墨昀琀匀姣玟闻玦矽捧芹夕们枻炜扬锐宋达维纹冰圊婵珍彧永笈鹦濯州荻卒韪善俅牌玫富纣中戆荣谊羽新泓栀渤桢鉴兴亦征嫚瑛芮济渲凡郁钦予兔堇娟洪微雷艾藤靖翡枝好衫春漫懈宛铮姬琵阗苈琳方俐臆栎翌涓二喧竦水藻化颉应鲤肖尚蕖嫂李愉世正殊孜旖香淩伟爱烁霏群建育言乐佟万汕泉涔依以瞳楚盈皓慧志蓓鐾湘兮卫立劬绍翠风千锡俊沅洛晞又凝彬良绣浍殷易敬引筑昆琨海皂洳鹊桧櫘至妙朝男初凯时偲余融露垚权印裳换蝶如辰苇汶与罐翔鎛谷莠丰妮轶满程星原仪俞环泽榕信温钠士元菁优祎函苘滟书研莤嫒篱闪渼期茉黍舄崔菩像珣宠人昙蝉骘叽烜卿宅坝妲蘩僮觎瞩琰申昭萼稼沁瓶姘喜深囡泳蕲卉柔科帆莉榆巧萩冬罕章毛豆虫溪裴滋陈笑妹高拉画弹本沐辛谣哎烦图鸾睆沛国脩纾空珠璎格南颜洋坤旋颕映慈廷涴珞靳禳向夏剑荧焱炎耿卓双承钬望恭烨怀银泠成酋芩昔俩穗常辉朱瑷柳迷麦澄鱼嬉漩汎漪昉弋烇晔炫壬绪欢隰雄锈城笛茈生蔼景橼员京鸿澜繁添递松淙揶糜妞谡丸侃四妗焮江邺非矫桂施匆妩碰桦豪霓远濠盛篮赛嫡铭煜腿旭舞骏珀愚榄莘埠笆垭之町礼潞少早声渝舟厅宝幼波嶷藕讨多镅杞钟朕仙栅私峄枞燮葵褶祐杼俣栽烟崴瑗关钕德知律浔臻岩粉朋喆果恳逾尥则淳茔杨憬释斯丝考杭玮椿兵乒鈊食收煊圆委司佑攸有河拙筠毅庐荥戏铱词枷蓬彩坎肜超泶铬武纤加顺发隽集来屙昳偌舲采鼐能聿岍崎嵘岖峙雟鹃燚音旱圭品贤颂同玛祢旨炯烂遥抹铎敖莞晏翁帷墉甑峥藝卯叫支掏捺瘴萦仲笫陇拒全琅牮六未逎相芒熠吟计并衣嫱薪古鸯珲祊憝蒹看妊薏拔名负璁芄阌锟墙尼叟俏瀚灶柃萧绘儿逍萎岢惮逢利泥闺垄闰碌请沄钧傲旦虞缔葆泺隐磐威押均延纪閃叡炽蜜卷谕益霜驿亿惜斐鹏攀莫母佘手畹宕畇材韻璟璋博姹琛慕跃光鹳瀛瀅姑伽谦具孔鄄稷交楷杉鳗贾浏兢";
        String firstNameForBoy="泽晨子桐建川琦锐家妍宇琪佳鑫语彤紫睿天懿轩谨瑶玉涵俊辰泊君无名书若栾恩韶杰美铭缘舒雨诺慧源静志刚振震翔诗怡腾冰跃景浩乐鹏林然璐帆曦航菡宸超青国梓琛成芳学圣一颖艺洋允博羽卓越丹萱嘉朗飞岚雅倩月绣棕星龙山峰爱淞松瑞才英兴光定云硕森新文远彬荣传化智祺晖金烁致海宾磊阳誉宏畅依洪东辉康亭婷皓昊昱焱旭炎尧魁伟园菁骏豪业永悌燕淏蓉浚妹姹义万荧汐悦凤烷析模欣卿帅凯娜焦竟晴清箐史晓泓霏岳逸宁明华浠瑄桂欲煜扬敏烘贵梦婕下放春思恒孜茹莺绎靖巍楷奕煦恺瑜楦暄煊璇珊晶婧瑾闯玲铁皖麓丞骧惘略竖太逖内驱藩斓夷亦暖仡屹蕾芸鱼未唯鸣亚勤大肉正坤进灵雪鲜峻运仕馨栎德挪心路遥武汉渊璟利忆兆绮苇孟淑言昂悠岐茁涯至寸沣曼蕊香薇平尹元岑洁芙优丽秋耽颂辙系媛禧璘亍淇赵舟颜地善柔王爷昶丙军楠佐镶萍莉寰虎耘麒墨江喆财亿喧珂彦泰霖凌入旨朵希轰阔懋念夕影熙晟炫烜麟炳勋艳霞苓全严斌涛漺占冉伊止銮顺玺丁宛之姜玥囡麦穗歆儿靓哲庭波密延强素北诚柯岩科研可沂民卫祚珣奎攸港连臣弘安驰曜绥尔芋璋继雳箕槟勇顼喜花沛潇澜梅忠宝惜贝兵婉鹤芝蓓士如焕果宽娇朋宗记礼译执署冠聪琳呈风萌朝霄毅盛栋润坡立娟法世罄初慈溪杜俐诊锦琴笔萧淩锡沁粟濡肃栖桢垚足异千巫崇颢诞存厚墩钰培欢瀚衍满敬鸿寒婼翰誓琾炜任闫谦亮程良惠乙达驿拾红颀哈嘻竹嶽信了维庆孚缨秀藏旋开生昕聚拥甜迪奇见发政狮锟兰基镕雄凡雯网吗咏富碧盈晋鲁胤骞澍琼御苍擎茜忻尚殿木纯凰贞苗淼水夏想升料倚耀芮鸥欧启增展帝儒澄绪得常则铸衡声途邦年纪合和城甫问翼宣府钧实钦菲爽苒滔仁赀芯余沥鹦还诩游妮彩婵蕴贤取霭祖禳柳眩长颍逊逮燃剑馥向漓首晗禹为中旻保苏娥黎璞熠祥昀昭茂容锋漠知添汝濠韬昌芷承矗漾工渡潼胜捷凝祝灏燊哥体徽鳆朔行帻罡征肩佻券纵镒芬适隶鄘袄璩葛题鼐憬湾鸾粮何住匠眼级佰收徕投决邠字珞先侦不皆沓协其往驷劬凃戆襄惯燮帜砧峦轻眉烨汶招琢拈多七倾恬铠毛小司格镔韦威钟羲佑樱吟仰繇壮又绩甲舜齐留茵枫校亟祐典炅作霈靜净傑销宕缤蔚缃瑛莹滢灿显伶钊纶柠皿琰少昵张赫朦银真朱煌洲钱妤有福闰牧銘賢锎坚沉琬益南庚苡泳以镇乔巧帧臻双健闻铎玮绍含韩郁施挥渤铧夫省雷漳倡琸续庄备宋幼汇蔼弈宥鉴员穆仪隽田勉圽与默及碑惶珍潞翌奉品微佩珈芪材肖媚杏修妃伦岭童非幸慎鴻荭珠帘菊吉颉霓倪偌锶党鳅支根权峡叠熔淳献斐男郎好师忝漩滇榕陈叶洛同息玫上晰錡什易稳拉劭浔组陶洽嫣石沐枕隆佟晔寓于羿伯刀粗晧筱祤柏友力韵浱泷慕浈笑拓桦烯后仙桃寮目埔珑鎏肄俞璁予阡陌兮西伲旎准治举宪辩豆瞳辚让绉糍付辛蓝旷赪姿能薪峙杨相荏闽娅女芊邈室曲鄃锻树营楚尤祈踊昴种冬徉贺佯河荷音蒙壕卉昨创铣阜蛮听乘膧沫萦垠浏楫查照策涅炬圻诲镌奠郢聃叙燚怜錾缔槿杉屯泵因铿隐冀拢妊郝滟埋理朴尘登函卯毕衔旺画径茧姥幂烆广蜇丛从唐鎲火嵘百坦形翟均豫瀵砚抱变馀鹰粤镆遇赞谯薹采湘僚彪览赠仲幛庞巨骥逻京吴锚搏育迎崧狄梁起意怀牌谙勖丰标卢群节频堪助樽骐温尼妙娴霆丝茗駿锵遵泌总恭诰菳筠祯酿邺彧芃铱奔孝";
        String name = "";
        if(gender==0){//判断要生成女生还是男生的名字 0是女生 1是男生
            String girlLastName=lastName[random.nextInt(lastName.length)];
            int index=random.nextInt(firstNameForGirl.length());
            String girlFirstName="";
            if (index<=firstNameForGirl.length()-2){//防止截取的字符超过最大索引
                int num=UsefulUtil.getRandomNumber(1,2);
                girlFirstName=firstNameForGirl.substring(index,index+num);
            }else{
                if(index==firstNameForGirl.length()){//如果index刚好等于字符串的最大长度 那么-2保证其不超过最大索引
                    index-=2;
                }else if(index==firstNameForGirl.length()-1){
                    index-=1;
                }else{
                    if(girlLastName.length()==2){
                        girlFirstName=firstNameForGirl.substring(index,index+2);
                    }else{
                        while (true){
                            int num=random.nextInt(3);
                            if(num!=0){
                                girlFirstName=firstNameForGirl.substring(index,index+num);
                                break;
                            }
                        }
                    }
                }
            }
            name=girlLastName+girlFirstName;
        }else if(gender==1){
            String boyLastName=lastName[random.nextInt(lastName.length)];
            int index=random.nextInt(firstNameForBoy.length());
            String boyFirstName="";
            if (index<=firstNameForBoy.length()-2){//防止截取的字符超过最大索引
                int num=UsefulUtil.getRandomNumber(1,2);
                boyFirstName=firstNameForBoy.substring(index,index+num);
            }else{
                if(index==firstNameForBoy.length()){//如果index刚好等于字符串的最大长度 那么-2保证其不超过最大索引
                    index-=2;
                }else if(index==firstNameForBoy.length()-1){
                    index-=1;
                }else{
                    if(boyLastName.length()==2){
                        boyFirstName=firstNameForBoy.substring(index,index+2);
                    }else{
                        while (true){
                            int num=random.nextInt(3);
                            if(num!=0){
                                boyFirstName=firstNameForBoy.substring(index,index+num);
                                break;
                            }
                        }
                    }
                }
            }
            name=boyLastName+boyFirstName;
        }
        return name;
    }

    /**
     *@param
     *@Author 赵富源
     *@Description 生成随机手机号码
     *@Return java.lang.String
     */
    public static String randomChinaPhoneNumber(){
        Random random=new Random();
        String phoneNumber="";
        String[] numberHead={"133","153","173","177","180","181","189","191","193","199","130","131","132","155","156","166","175","176","185","186","135","136","137","138","139","147","150","151","152","157","158","159","172","178","182","183","184","187","188","198"};
        String[] numbers={"0","1","2","3","4","5","6","7","8","9"};
        String phoneNumberHead=numberHead[random.nextInt(numberHead.length)];
        StringBuilder phoneNumbers=new StringBuilder();
        for(int i=0;i<numbers.length-2;i++){
            phoneNumbers.insert(i,numbers[random.nextInt(numbers.length)]);
        }
        phoneNumber=phoneNumberHead+phoneNumbers;
        return phoneNumber;
    }

    /**
     *@param
     *@Author 赵富源
     *@Description 生成随机电子邮箱
     *@Return java.lang.String
     */
    public static String randomEmailAddress(){
        Random random=new Random();
        String email="";
        String[] loginName={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};
        String[] hostName={"email","outlook","gmail","hotmail","163","qq","126","yeah","sina","139"};
        String[] domainName={".com",".net",".edu",".org",".me",".cn",".uk",".club"};
        StringBuilder fulLoginName=new StringBuilder();
        for(int i=0;i<UsefulUtil.getRandomNumber(3,13);i++){
            fulLoginName.insert(i,loginName[random.nextInt(loginName.length)]);
        }
        email=fulLoginName+"@"+hostName[random.nextInt(hostName.length)]+domainName[random.nextInt(domainName.length)];
        return email;
    }

    /**
     *@param
     *@Author 赵富源
     *@Description 生成随机性别
     *@Return java.lang.String
     */
    public static String randomGender(){
        Random random=new Random();
        int gender=1;
        if(random.nextInt(2)==0){
            gender=0;
        }
        return String.valueOf(gender);
    }

    /**
     *@param
     *@Author 赵富源
     *@Description 随机生成true|false
     *@Return java.lang.String
     */
    public static boolean randomBoolean(){
        Random random=new Random();
        boolean b=true;
        if(random.nextInt(2)==0){
            b=false;
        }
        return b;
    }
}