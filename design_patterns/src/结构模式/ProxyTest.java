package 结构模式;

public class ProxyTest {
    public static void main(String[] args) {
        SuFans suFans = new SuFans(30, true);
        Art su = new SuTungPo();
        LinFans linFans = new LinFans(su, suFans);
        linFans.writePoets();
    }
}

interface Art {
    void writePoets();//诗

    void writeCis();//词

    void writeProse();//散文

    void writeEssays();//议论文

    void paint();//绘画

    void handwriting();//书法

    void foodie();//吃货

    void cook();//厨师

    void joke();//开玩笑

    void official();//官员

    void farmer();//农民

    void geek();//极客

    void selfLove();//自爱

    void universalLove();//博爱

    void romantic();//浪漫

    void optimist();//乐观

}

interface LinYuTang {
    void an_incorrigible_optimist();

    void a_great_humanitarian();

    void a_friend_of_the_people();

    void a_prose_master();

    void an_original_painter();

    void a_great_calligraphist();

    void an_experimenter_in_wine_making();

    void an_engineer();

    void a_hater_of_puritanism();

    void a_yogi();

    void a_Buddhist_believer();

    void a_Confucian_statesman();

    void a_secretary_to_the_emperor();

    void a_confirmed_winebibber();

    void a_humane_judge();

    void a_dissenter_in_politics();

    void a_prowler_in_the_moonlight();

    void a_poet();

    void and_a_wag();
}

class SuFans {
    private int poetNum;
    private boolean loveSu;

    public SuFans(int poetNum, boolean loveSu) {
        this.poetNum = poetNum;
        this.loveSu = loveSu;
    }

    public int getPoetNum() {
        return poetNum;
    }

    public boolean isLoveSu() {
        return loveSu;
    }

    public void setPoetNum(int poetNum) {
        this.poetNum = poetNum;
    }

    public void setLoveSu(boolean loveSu) {
        this.loveSu = loveSu;
    }
}

class LinFans implements Art {
    private Art artist;
    private SuFans suFans;

    public LinFans(Art artist, SuFans suFans) {
        System.out.println("One might say that Su Tungpo was an incorrigible optimist, " +
                "a great humanitarian, a friend of the people, a prose master, an original painter, " +
                "a great calligraphist, an experimenter in wine making, an engineer, " +
                "a hater of puritanism, a yogi, a Buddhist believer, a Confucian statesman, " +
                "a secretary to the emperor, a confirmed winebibber, a humane judge, " +
                "a dissenter in politics, a prowler in the moonlight, a poet, and a wag.");
        this.artist = artist;
        this.suFans = suFans;
    }

    @Override
    public void writePoets() {
        if (suFans.isLoveSu()) {
            System.out.println("a poet");
            if (suFans.getPoetNum() >= 3) {
                artist.writePoets();
            } else {
                System.out.println("没背够三首诗，没资格奥！");
            }
        } else {
            System.out.println("我们东坡只给苏粉写诗!");
        }

    }

    @Override
    public void writeCis() {
        artist.writeCis();
    }

    @Override
    public void writeProse() {
        System.out.println("a prose master");
        artist.writeProse();
    }

    @Override
    public void writeEssays() {
        artist.writeEssays();
    }

    @Override
    public void paint() {
        System.out.println("an original painter");
        artist.paint();
    }

    @Override
    public void handwriting() {
        System.out.println("a great calligraphist");
        artist.handwriting();
    }

    @Override
    public void foodie() {
        artist.foodie();
    }

    @Override
    public void cook() {
        artist.cook();
    }

    @Override
    public void joke() {
        System.out.println("a wag");
        artist.joke();
    }

    @Override
    public void official() {
        System.out.println("a humane judge, a Confucian statesman, a secretary to the emperor, a dissenter in politics");
        artist.official();
    }

    @Override
    public void farmer() {
        artist.farmer();
    }

    @Override
    public void geek() {
        System.out.println("an experimenter in wine making, an engineer");
    }

    @Override
    public void selfLove() {
        System.out.println("a yogi, a Buddhist believer");
        artist.selfLove();
    }

    @Override
    public void universalLove() {
        System.out.println("a great humanitarian, a friend of the people, a hater of puritanism");
        artist.universalLove();
    }

    @Override
    public void romantic() {
        System.out.println("a confirmed winebibber, a prowler in the moonlight");
        artist.romantic();
    }

    @Override
    public void optimist() {
        System.out.println("an incorrigible optimist");
        artist.optimist();
    }

}

class SuTungPo implements Art {

    @Override
    public void writePoets() {
        System.out.println("八月十八潮，壮观天下无。——《催试官考较戏作》");
        System.out.println("竹外桃花三两枝，春江水暖鸭先知。蒌蒿满地芦芽短，正是河豚欲上时。——《惠崇春江晚景》");
        System.out.println("水光潋滟晴方好，山色空蒙雨亦奇。欲把西湖比西子，淡妆浓抹总相宜。——《饮湖上初晴后雨》");
        System.out.println("东风袅袅泛崇光，香雾空蒙月转廊。只恐夜深花睡去，故烧高烛照红妆。——《海棠》");
        System.out.println("一年好景君须记，最是橙黄橘绿时。——《赠刘景文》");
        System.out.println("粗缯大布裹生涯，腹有诗书气自华。——《和董传留别》");
        System.out.println("人生到处知何似，应似飞鸿踏雪泥。泥上偶然留指爪，鸿飞哪复计东西。——《和子由渑池怀旧》");
        System.out.println("春宵一刻值千金，花有清香月有阴。歌管楼台声细细，秋千院落夜沉沉。——《春夜》");
        System.out.println("横看成岭侧成峰，远近高低各不同。不识庐山真面目，只缘身在此山中。——《题西林壁》");
        System.out.println("若言琴上有琴声，放在匣中何不鸣。若言声在指头上，何不于君指上听。——《琴诗》");
        System.out.println("惆怅东栏一株雪，人生看得几清明。——《东栏梨花》");
        System.out.println("我家江水初发源，宦游直送江入海。……江心似有炬火明，飞焰照山栖鸟惊。——《游金山寺》");
        System.out.println("空庖煮寒菜，破灶烧湿苇。那知是寒食，但见乌衔纸。君门深九重，坟墓在万里。也拟哭途穷，死灰吹不起。——《黄州寒食帖》");

    }

    @Override
    public void writeCis() {
        System.out.println("但愿人长久，千里共婵娟。——《水调歌头·丙辰中秋》");
        System.out.println("会挽雕弓如满月，西北望，射天狼。——《江城子·密州出猎》");
        System.out.println("大江东去浪淘尽，千古风流人物。——《念奴娇·赤壁怀古》");
        System.out.println("谁怕，一蓑烟雨任平生。——《定风波》");
        System.out.println("雪沫乳花浮午盏，蓼茸蒿笋试春盘。人间有味是清欢。——《浣溪沙》");
        System.out.println("几时归去，作个闲人，对一张琴，一壶酒，一溪云。——《行香子·述怀》");
        System.out.println("拣尽寒枝不肯栖，寂寞沙洲冷。——《卜算子》");
        System.out.println("十年生死两茫茫，不思量自难忘。千里孤坟，无处话凄凉。——《江城子·乙卯正月二十日记梦》");
        System.out.println("休对故人思故国，且将新火试新茶。诗酒趁年华。——《望江南·超然台作》");
        System.out.println("休言万事转头空，未转头时是梦。——《西江月·平山堂》");
        System.out.println("暮云收尽溢清寒，银汉无声转玉盘。此生此夜不长好，明月明年何处看。——《阳关曲·中秋作》");
        System.out.println("凤凰山下雨初晴，水风清，晚霞明。一朵芙蕖，开过尚盈盈。何处飞来双白鹭，如有意，慕娉婷。" +
                "忽闻江上弄哀筝，苦含情，遣谁听！烟敛云收，依约是湘灵。欲待曲终寻问取，人不见，数峰青。——《江城子·湖上与张先同赋时闻弹筝》");
        System.out.println("琅然，清圆，谁弹，响空山，无言……此意在人间，试听徽外三两弦。——《醉翁操》");
        System.out.println("恰似姮娥怜双燕，分明照、画梁斜。——《少年游》");

    }

    @Override
    public void writeProse() {
        System.out.println("古之立大事者，不惟有超世之才，亦必有坚韧不拔之志。——《晁错论》");
        System.out.println("天下有大勇者，卒然临之而不惊，无故加之而不怒。——《留侯论》");
        System.out.println("何夜无月，何处无竹柏，但少闲人如吾两人耳。——《记承天寺夜游》");
        System.out.println("故画竹必先得成竹于胸中，执笔熟视，乃见其所欲画者，急起从之，振笔直遂，以追其所见，如兔起鹘落，少纵则逝矣。——《文与可画侉篔筜谷偃竹记》");
        System.out.println("凡物皆有可观。苟有可观，皆有可乐，非必怪奇伟丽者也。哺糟啜醨皆可以醉；果蔬草木，皆可以饱。推此类也，吾安往而不乐？……" +
                "方是时，予弟子由，适在济南，闻而赋之，且名其台曰“超然”，以见余之无所往而不乐者，盖游于物之外也。——《超然台记》");
        System.out.println("亭以雨名，志喜也。古者有喜，则以名物，示不忘也。——《喜雨亭记》");
        System.out.println("事不目见耳闻，而臆断其有无，可乎？……而陋者乃以斧斤考击而求之，自以为得其实。余是以记之，盖叹郦元之简，而笑李渤之陋也。——《石钟山记》");
        System.out.println("江流有声，断岸千尺；山高月小，水落石出。曾日月之几何，而江山不可复识矣。……划然长啸，草木震动，山鸣谷应，风起水涌。予亦悄然而悲，肃然而恐，凛乎其不可留也。" +
                "反而登舟，放乎中流，听其所止而休焉。时夜将半，四顾寂寥。适有孤鹤，横江东来。翅如车轮，玄裳缟衣，戛然长鸣，掠予舟而西也。" +
                "须臾客去，予亦就睡。梦一道士，羽衣蹁跹，过临皋之下，揖予而言曰：“赤壁之游乐乎？”问其姓名，俯而不答。" +
                "“呜呼！噫嘻！我知之矣。畴昔之夜，飞鸣而过我者，非子也邪？”道士顾笑，予亦惊寤。" +
                "开户视之，不见其处。");
        System.out.println("彭城之山，冈岭四合，隐然如大环，独缺其西一面，而山人之亭，适当其缺。春夏之交，草木际天；秋冬雪月，千里一色；风雨晦明之间，俯仰百变。……" +
                "子知隐居之乐乎？虽南面之君，未可与易也。……嗟夫！南面之君，虽清远闲放如鹤者，犹不得好，好之则亡其国；" +
                "而山林遁世之士，虽荒惑败乱如酒者，犹不能为害，而况于鹤乎？由此观之，其为乐未可以同日而语也。——《放鹤亭记》");
    }

    @Override
    public void writeEssays() {
        System.out.println();
        System.out.println("有一善，从而赏之，又从而咏歌嗟叹之，所以乐其始而勉其终。有一不善，从而罚之，又从而哀矜惩创之，所以弃其旧而开其新。故其吁俞之声，欢休惨戚，见于虞、夏、商、周之书。" +
                "其言忧而不伤，威而不怒，慈爱而能断，恻然有哀怜无辜之心，故孔子犹有取焉。" +
                "可以赏，可以无赏，赏之过乎仁；可以罚，可以无罚，罚之过乎义。过乎仁，不失为君子；过乎义，则流而入于忍人。故仁可过也，义不可过也。" +
                "是故疑则举而归之于仁，以君子长者之道待天下，使天下相率而归于君子长者之道。故曰：忠厚之至也。" +
                "《春秋》之义，立法贵严，而责人贵宽。因其褒贬义，以制赏罚，亦忠厚之至也。——《刑赏忠厚之至论》");
        System.out.println("盖将自其变者而观之，则天地能不能以一瞬，自其不变者而观之，则物与我皆无尽也，而又何羡乎。" +
                "且夫天地之间，物各有主，苟非吾之所有，虽一毫而莫取。惟江上之清风，与山间之明月，耳得之而为声，目遇之而成色，" +
                "取之无禁，用之不竭。是造物者之无尽藏也，而吾与子之所共适。" +
                "客喜而笑，洗盏更酌。肴核既尽，杯盘狼籍。相与枕藉乎舟中，不知东方之既白。——《赤壁赋》");
    }

    @Override
    public void paint() {

    }

    @Override
    public void handwriting() {

    }

    @Override
    public void foodie() {

    }

    @Override
    public void cook() {

    }

    @Override
    public void joke() {

    }

    @Override
    public void official() {
        System.out.println("除去为父母丁忧的6年，苏轼的仕宦生涯可以用428487总结：");
        System.out.println("4，1061.12-1064.12(凤翔签判)，" +
                "2，1064.12-1066.4(开封史官)，" +
                "[3，1066.4-1068.11(眉州丁忧)]，" +
                "[2，1069.2-1071.4(开封史官、推官2.5)]，" +
                "8，1071.11-1079.12(杭州通判3.5+密州2+徐州2+湖州3月+监狱130天4个月)，" +
                "4，1080.2-1084.4(黄州)，" +
                "8，1086-1094(登州+杭州+开封+颍州+扬州)，" +
                "7，1094-1101(定州+惠州+儋州)");
        System.out.println("他一共活到64周岁，也就8个8年。除去努力学习的3个8年，除去为父母守孝的1个8年，也就剩下4个8年了。" +
                "这4个8年，他一分都没有虚度，青年努力成长，当官为百姓奔走，蹲监狱通宵诟辱，改造需求佛道拥抱自然，在中央就事论事，到地方造福百姓，贬海南开化文明，" +
                "永远怀抱希望，永远买房置地，永远乐观生活，永远爱自己，永远爱身边人，永远爱百姓。怎么会有这么可爱的人，可偏偏他苏东坡就是！" +
                "2021-9-16 08:43:12。一夜未眠，半宿苏海。");
    }

    @Override
    public void farmer() {

    }

    @Override
    public void geek() {

    }

    @Override
    public void selfLove() {

    }

    @Override
    public void universalLove() {

    }

    @Override
    public void romantic() {

    }

    @Override
    public void optimist() {

    }


}