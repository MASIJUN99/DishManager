package com.example.pojo;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

  public static String[] ZH_CN_NAME;

  static {
    ZH_CN_NAME = new String[]{
        "五花肉","排骨","肉沫","瘦肉片","瘦肉丝","猪血","猪肝","火腿","卤猪头肉","猪蹄","卤大肠","猪肚","培根","腊肉","肘子","牛肉","牛骨","牛里脊肉","牛腩","熟牛杂","羊肉","羊排","五香板鸭","鸭边腿","鸭珍","乌鸡","鸡米花","白条鸡","鸡胸肉","翅中","琵琶腿","鸭肉","奥尔良鸡排","盐水鸭","烤鸭","兔肉","田鸡","草鱼","小黄鱼","黄瓜鱼","鲈鱼","肉鲳","秋刀鱼","鸦片鱼头","巴沙鱼柳","带鱼","鲫鱼","鱿鱼","金昌鱼","青蛾","鲍鱼","花蛤","虾","螃蟹","虾仁","胖鱼头","海蛎","海蛏","海虹","包公鱼","胡瓜","冬瓜","大白菜","宽粉","白萝卜","红萝卜","黄豆芽","绿豆芽","红菜椒","菜椒","黄菜椒","青尖椒","红尖椒","小青米椒","小红米椒","泡椒","蒜台","洋葱","黄瓜","湿木耳","杏鲍菇","海鲜菇","莲藕","冬笋","土豆","茭白","莴笋","四季豆","地瓜","山药","西芹","包菜","大葱","长杆豆","西红柿","丝瓜","韭菜","韭黄","苦瓜","花菜","荷兰豆","娃娃菜","香菇贡丸","芋头","千叶豆腐","豆腐","豆泡","卤香干","上海青","天津白","芥菜","生菜","空心菜","菜心","红苋菜","金针菇","秋葵","菠菜","木耳菜","鱼滑","鱼丸","肉燕","玉米粒","面筋","海带结","腐竹","鹌鹑蛋","干茶树菇","玉米","豆秸","泡发笋干","糯米","蒸肉粉","蒜苗","梅菜（干）","酸菜","香菜","老姜","槟榔芋","平菇","雪里红","海鹰香肠","茄子",
    };
  }


  private Integer id      = 0;
  private Double wu_hua_rou = 0.0;
  private Double pai_gu = 0.0;
  private Double rou_mo = 0.0;
  private Double shou_rou_pian = 0.0;
  private Double shou_rou_si = 0.0;
  private Double zhu_xue = 0.0;
  private Double zhu_gan = 0.0;
  private Double huo_tui = 0.0;
  private Double lu_zhu_tou_rou = 0.0;
  private Double zhu_ti = 0.0;
  private Double lu_da_chang = 0.0;
  private Double zhu_du = 0.0;
  private Double pei_gen = 0.0;
  private Double la_rou = 0.0;
  private Double zhou_zi = 0.0;
  private Double niu_rou = 0.0;
  private Double niu_gu = 0.0;
  private Double niu_li_ji_rou = 0.0;
  private Double niu_nan = 0.0;
  private Double shu_niu_za = 0.0;
  private Double yang_rou = 0.0;
  private Double yang_pai = 0.0;
  private Double wu_xiang_ban_ya = 0.0;
  private Double ya_bian_tui = 0.0;
  private Double ya_zhen = 0.0;
  private Double wu_ji = 0.0;
  private Double ji_mi_hua = 0.0;
  private Double bai_tiao_ji = 0.0;
  private Double ji_xiong_rou = 0.0;
  private Double chi_zhong = 0.0;
  private Double pi_pa_tui = 0.0;
  private Double ya_rou = 0.0;
  private Double ao_er_liang_ji_pai = 0.0;
  private Double yan_shui_ya = 0.0;
  private Double kao_ya = 0.0;
  private Double tu_rou = 0.0;
  private Double tian_ji = 0.0;
  private Double cao_yu = 0.0;
  private Double xiao_huang_yu = 0.0;
  private Double huang_gua_yu = 0.0;
  private Double lu_yu = 0.0;
  private Double rou_ = 0.0;
  private Double qiu_dao_yu = 0.0;
  private Double ya_pian_yu_tou = 0.0;
  private Double ba_sha_yu_liu = 0.0;
  private Double dai_yu = 0.0;
  private Double ji_yu = 0.0;
  private Double you_yu = 0.0;
  private Double jin_chang_yu = 0.0;
  private Double qing_e = 0.0;
  private Double bao_yu = 0.0;
  private Double hua_ge = 0.0;
  private Double xia = 0.0;
  private Double pang_xie = 0.0;
  private Double xia_ren = 0.0;
  private Double pang_yu_tou = 0.0;
  private Double hai_li = 0.0;
  private Double hai_cheng = 0.0;
  private Double hai_hong = 0.0;
  private Double bao_gong_yu = 0.0;
  private Double hu_gua = 0.0;
  private Double dong_gua = 0.0;
  private Double da_bai_cai = 0.0;
  private Double kuan_fen = 0.0;
  private Double bai_luo_bo = 0.0;
  private Double hong_luo_bo = 0.0;
  private Double huang_dou_ya = 0.0;
  private Double lv_dou_ya = 0.0;
  private Double hong_cai_jiao = 0.0;
  private Double cai_jiao = 0.0;
  private Double huang_cai_jiao = 0.0;
  private Double qing_jian_jiao = 0.0;
  private Double hong_jian_jiao = 0.0;
  private Double xiao_qing_mi_jiao = 0.0;
  private Double xiao_hong_mi_jiao = 0.0;
  private Double pao_jiao = 0.0;
  private Double suan_tai = 0.0;
  private Double yang_cong = 0.0;
  private Double huang_gua = 0.0;
  private Double shi_mu_er = 0.0;
  private Double xing_bao_gu = 0.0;
  private Double hai_xian_gu = 0.0;
  private Double lian_ou = 0.0;
  private Double dong_sun = 0.0;
  private Double tu_dou = 0.0;
  private Double jiao_bai = 0.0;
  private Double wo_sun = 0.0;
  private Double si_ji_dou = 0.0;
  private Double di_gua = 0.0;
  private Double shan_yao = 0.0;
  private Double xi_qin = 0.0;
  private Double bao_cai = 0.0;
  private Double da_cong = 0.0;
  private Double chang_gan_dou = 0.0;
  private Double xi_hong_shi = 0.0;
  private Double si_gua = 0.0;
  private Double jiu_cai = 0.0;
  private Double jiu_huang = 0.0;
  private Double ku_gua = 0.0;
  private Double hua_cai = 0.0;
  private Double he_lan_dou = 0.0;
  private Double wa_wa_cai = 0.0;
  private Double xiang_gu_gong_wan = 0.0;
  private Double yu_tou = 0.0;
  private Double qian_ye_dou_fu = 0.0;
  private Double dou_fu = 0.0;
  private Double dou_pao = 0.0;
  private Double lu_xiang_gan = 0.0;
  private Double shang_hai_qing = 0.0;
  private Double tian_jin_bai = 0.0;
  private Double jie_cai = 0.0;
  private Double sheng_cai = 0.0;
  private Double kong_xin_cai = 0.0;
  private Double cai_xin = 0.0;
  private Double hong_xian_cai = 0.0;
  private Double jin_zhen_gu = 0.0;
  private Double qiu_kui = 0.0;
  private Double bo_cai = 0.0;
  private Double mu_er_cai = 0.0;
  private Double yu_hua = 0.0;
  private Double yu_wan = 0.0;
  private Double rou_yan = 0.0;
  private Double yu_mi_li = 0.0;
  private Double mian_jin = 0.0;
  private Double hai_dai_jie = 0.0;
  private Double fu_zhu = 0.0;
  private Double an_chun_dan = 0.0;
  private Double gan_cha_shu_gu = 0.0;
  private Double yu_mi = 0.0;
  private Double dou_jie = 0.0;
  private Double pao_fa_sun_gan = 0.0;
  private Double nuo_mi = 0.0;
  private Double zheng_rou_fen = 0.0;
  private Double suan_miao = 0.0;
  private Double mei_cai_gan = 0.0;
  private Double suan_cai = 0.0;
  private Double xiang_cai = 0.0;
  private Double lao_jiang = 0.0;
  private Double bing_lang_yu = 0.0;
  private Double ping_gu = 0.0;
  private Double xue_li_hong = 0.0;
  private Double hai_ying_xiang_chang = 0.0;
  private Double qie_zi = 0.0;

  public Recipe(Double wu_hua_rou, Double pai_gu, Double rou_mo, Double shou_rou_pian,
      Double shou_rou_si, Double zhu_xue, Double zhu_gan, Double huo_tui,
      Double lu_zhu_tou_rou, Double zhu_ti, Double lu_da_chang, Double zhu_du,
      Double pei_gen, Double la_rou, Double zhou_zi, Double niu_rou, Double niu_gu,
      Double niu_li_ji_rou, Double niu_nan, Double shu_niu_za, Double yang_rou,
      Double yang_pai, Double wu_xiang_ban_ya, Double ya_bian_tui, Double ya_zhen,
      Double wu_ji, Double ji_mi_hua, Double bai_tiao_ji, Double ji_xiong_rou,
      Double chi_zhong, Double pi_pa_tui, Double ya_rou, Double ao_er_liang_ji_pai,
      Double yan_shui_ya, Double kao_ya, Double tu_rou, Double tian_ji, Double cao_yu,
      Double xiao_huang_yu, Double huang_gua_yu, Double lu_yu, Double rou_,
      Double qiu_dao_yu, Double ya_pian_yu_tou, Double ba_sha_yu_liu, Double dai_yu,
      Double ji_yu, Double you_yu, Double jin_chang_yu, Double qing_e, Double bao_yu,
      Double hua_ge, Double xia, Double pang_xie, Double xia_ren, Double pang_yu_tou,
      Double hai_li, Double hai_cheng, Double hai_hong, Double bao_gong_yu, Double hu_gua,
      Double dong_gua, Double da_bai_cai, Double kuan_fen, Double bai_luo_bo,
      Double hong_luo_bo, Double huang_dou_ya, Double lv_dou_ya, Double hong_cai_jiao,
      Double cai_jiao, Double huang_cai_jiao, Double qing_jian_jiao, Double hong_jian_jiao,
      Double xiao_qing_mi_jiao, Double xiao_hong_mi_jiao, Double pao_jiao, Double suan_tai,
      Double yang_cong, Double huang_gua, Double shi_mu_er, Double xing_bao_gu,
      Double hai_xian_gu, Double lian_ou, Double dong_sun, Double tu_dou, Double jiao_bai,
      Double wo_sun, Double si_ji_dou, Double di_gua, Double shan_yao, Double xi_qin,
      Double bao_cai, Double da_cong, Double chang_gan_dou, Double xi_hong_shi,
      Double si_gua, Double jiu_cai, Double jiu_huang, Double ku_gua, Double hua_cai,
      Double he_lan_dou, Double wa_wa_cai, Double xiang_gu_gong_wan, Double yu_tou,
      Double qian_ye_dou_fu, Double dou_fu, Double dou_pao, Double lu_xiang_gan,
      Double shang_hai_qing, Double tian_jin_bai, Double jie_cai, Double sheng_cai,
      Double kong_xin_cai, Double cai_xin, Double hong_xian_cai, Double jin_zhen_gu,
      Double qiu_kui, Double bo_cai, Double mu_er_cai, Double yu_hua, Double yu_wan,
      Double rou_yan, Double yu_mi_li, Double mian_jin, Double hai_dai_jie, Double fu_zhu,
      Double an_chun_dan, Double gan_cha_shu_gu, Double yu_mi, Double dou_jie,
      Double pao_fa_sun_gan, Double nuo_mi, Double zheng_rou_fen, Double suan_miao,
      Double mei_cai_gan, Double suan_cai, Double xiang_cai, Double lao_jiang,
      Double bing_lang_yu, Double ping_gu, Double xue_li_hong, Double hai_ying_xiang_chang,
      Double qie_zi) {
    this.wu_hua_rou = wu_hua_rou;
    this.pai_gu = pai_gu;
    this.rou_mo = rou_mo;
    this.shou_rou_pian = shou_rou_pian;
    this.shou_rou_si = shou_rou_si;
    this.zhu_xue = zhu_xue;
    this.zhu_gan = zhu_gan;
    this.huo_tui = huo_tui;
    this.lu_zhu_tou_rou = lu_zhu_tou_rou;
    this.zhu_ti = zhu_ti;
    this.lu_da_chang = lu_da_chang;
    this.zhu_du = zhu_du;
    this.pei_gen = pei_gen;
    this.la_rou = la_rou;
    this.zhou_zi = zhou_zi;
    this.niu_rou = niu_rou;
    this.niu_gu = niu_gu;
    this.niu_li_ji_rou = niu_li_ji_rou;
    this.niu_nan = niu_nan;
    this.shu_niu_za = shu_niu_za;
    this.yang_rou = yang_rou;
    this.yang_pai = yang_pai;
    this.wu_xiang_ban_ya = wu_xiang_ban_ya;
    this.ya_bian_tui = ya_bian_tui;
    this.ya_zhen = ya_zhen;
    this.wu_ji = wu_ji;
    this.ji_mi_hua = ji_mi_hua;
    this.bai_tiao_ji = bai_tiao_ji;
    this.ji_xiong_rou = ji_xiong_rou;
    this.chi_zhong = chi_zhong;
    this.pi_pa_tui = pi_pa_tui;
    this.ya_rou = ya_rou;
    this.ao_er_liang_ji_pai = ao_er_liang_ji_pai;
    this.yan_shui_ya = yan_shui_ya;
    this.kao_ya = kao_ya;
    this.tu_rou = tu_rou;
    this.tian_ji = tian_ji;
    this.cao_yu = cao_yu;
    this.xiao_huang_yu = xiao_huang_yu;
    this.huang_gua_yu = huang_gua_yu;
    this.lu_yu = lu_yu;
    this.rou_ = rou_;
    this.qiu_dao_yu = qiu_dao_yu;
    this.ya_pian_yu_tou = ya_pian_yu_tou;
    this.ba_sha_yu_liu = ba_sha_yu_liu;
    this.dai_yu = dai_yu;
    this.ji_yu = ji_yu;
    this.you_yu = you_yu;
    this.jin_chang_yu = jin_chang_yu;
    this.qing_e = qing_e;
    this.bao_yu = bao_yu;
    this.hua_ge = hua_ge;
    this.xia = xia;
    this.pang_xie = pang_xie;
    this.xia_ren = xia_ren;
    this.pang_yu_tou = pang_yu_tou;
    this.hai_li = hai_li;
    this.hai_cheng = hai_cheng;
    this.hai_hong = hai_hong;
    this.bao_gong_yu = bao_gong_yu;
    this.hu_gua = hu_gua;
    this.dong_gua = dong_gua;
    this.da_bai_cai = da_bai_cai;
    this.kuan_fen = kuan_fen;
    this.bai_luo_bo = bai_luo_bo;
    this.hong_luo_bo = hong_luo_bo;
    this.huang_dou_ya = huang_dou_ya;
    this.lv_dou_ya = lv_dou_ya;
    this.hong_cai_jiao = hong_cai_jiao;
    this.cai_jiao = cai_jiao;
    this.huang_cai_jiao = huang_cai_jiao;
    this.qing_jian_jiao = qing_jian_jiao;
    this.hong_jian_jiao = hong_jian_jiao;
    this.xiao_qing_mi_jiao = xiao_qing_mi_jiao;
    this.xiao_hong_mi_jiao = xiao_hong_mi_jiao;
    this.pao_jiao = pao_jiao;
    this.suan_tai = suan_tai;
    this.yang_cong = yang_cong;
    this.huang_gua = huang_gua;
    this.shi_mu_er = shi_mu_er;
    this.xing_bao_gu = xing_bao_gu;
    this.hai_xian_gu = hai_xian_gu;
    this.lian_ou = lian_ou;
    this.dong_sun = dong_sun;
    this.tu_dou = tu_dou;
    this.jiao_bai = jiao_bai;
    this.wo_sun = wo_sun;
    this.si_ji_dou = si_ji_dou;
    this.di_gua = di_gua;
    this.shan_yao = shan_yao;
    this.xi_qin = xi_qin;
    this.bao_cai = bao_cai;
    this.da_cong = da_cong;
    this.chang_gan_dou = chang_gan_dou;
    this.xi_hong_shi = xi_hong_shi;
    this.si_gua = si_gua;
    this.jiu_cai = jiu_cai;
    this.jiu_huang = jiu_huang;
    this.ku_gua = ku_gua;
    this.hua_cai = hua_cai;
    this.he_lan_dou = he_lan_dou;
    this.wa_wa_cai = wa_wa_cai;
    this.xiang_gu_gong_wan = xiang_gu_gong_wan;
    this.yu_tou = yu_tou;
    this.qian_ye_dou_fu = qian_ye_dou_fu;
    this.dou_fu = dou_fu;
    this.dou_pao = dou_pao;
    this.lu_xiang_gan = lu_xiang_gan;
    this.shang_hai_qing = shang_hai_qing;
    this.tian_jin_bai = tian_jin_bai;
    this.jie_cai = jie_cai;
    this.sheng_cai = sheng_cai;
    this.kong_xin_cai = kong_xin_cai;
    this.cai_xin = cai_xin;
    this.hong_xian_cai = hong_xian_cai;
    this.jin_zhen_gu = jin_zhen_gu;
    this.qiu_kui = qiu_kui;
    this.bo_cai = bo_cai;
    this.mu_er_cai = mu_er_cai;
    this.yu_hua = yu_hua;
    this.yu_wan = yu_wan;
    this.rou_yan = rou_yan;
    this.yu_mi_li = yu_mi_li;
    this.mian_jin = mian_jin;
    this.hai_dai_jie = hai_dai_jie;
    this.fu_zhu = fu_zhu;
    this.an_chun_dan = an_chun_dan;
    this.gan_cha_shu_gu = gan_cha_shu_gu;
    this.yu_mi = yu_mi;
    this.dou_jie = dou_jie;
    this.pao_fa_sun_gan = pao_fa_sun_gan;
    this.nuo_mi = nuo_mi;
    this.zheng_rou_fen = zheng_rou_fen;
    this.suan_miao = suan_miao;
    this.mei_cai_gan = mei_cai_gan;
    this.suan_cai = suan_cai;
    this.xiang_cai = xiang_cai;
    this.lao_jiang = lao_jiang;
    this.bing_lang_yu = bing_lang_yu;
    this.ping_gu = ping_gu;
    this.xue_li_hong = xue_li_hong;
    this.hai_ying_xiang_chang = hai_ying_xiang_chang;
    this.qie_zi = qie_zi;
  }

  public void add(Recipe recipe) {
    this.wu_hua_rou             += recipe.getWu_hua_rou();
    this.pai_gu                 += recipe.getPai_gu();
    this.rou_mo                 += recipe.getRou_mo();
    this.shou_rou_pian          += recipe.getShou_rou_pian();
    this.shou_rou_si            += recipe.getShou_rou_si();
    this.zhu_xue                += recipe.getZhu_xue();
    this.zhu_gan                += recipe.getZhu_gan();
    this.huo_tui                += recipe.getHuo_tui();
    this.lu_zhu_tou_rou         += recipe.getLu_zhu_tou_rou();
    this.zhu_ti                 += recipe.getZhu_ti();
    this.lu_da_chang            += recipe.getLu_da_chang();
    this.zhu_du                 += recipe.getZhu_du();
    this.pei_gen                += recipe.getPei_gen();
    this.la_rou                 += recipe.getLa_rou();
    this.zhou_zi                += recipe.getZhou_zi();
    this.niu_rou                += recipe.getNiu_rou();
    this.niu_gu                 += recipe.getNiu_gu();
    this.niu_li_ji_rou          += recipe.getNiu_li_ji_rou();
    this.niu_nan                += recipe.getNiu_nan();
    this.shu_niu_za             += recipe.getShu_niu_za();
    this.yang_rou               += recipe.getYang_rou();
    this.yang_pai               += recipe.getYang_pai();
    this.wu_xiang_ban_ya        += recipe.getWu_xiang_ban_ya();
    this.ya_bian_tui            += recipe.getYa_bian_tui();
    this.ya_zhen                += recipe.getYa_zhen();
    this.wu_ji                  += recipe.getWu_ji();
    this.ji_mi_hua              += recipe.getJi_mi_hua();
    this.bai_tiao_ji            += recipe.getBai_tiao_ji();
    this.ji_xiong_rou           += recipe.getJi_xiong_rou();
    this.chi_zhong              += recipe.getChi_zhong();
    this.pi_pa_tui              += recipe.getPi_pa_tui();
    this.ya_rou                 += recipe.getYa_rou();
    this.ao_er_liang_ji_pai     += recipe.getAo_er_liang_ji_pai();
    this.yan_shui_ya            += recipe.getYan_shui_ya();
    this.kao_ya                 += recipe.getKao_ya();
    this.tu_rou                 += recipe.getTu_rou();
    this.tian_ji                += recipe.getTian_ji();
    this.cao_yu                 += recipe.getCao_yu();
    this.xiao_huang_yu          += recipe.getXiao_huang_yu();
    this.huang_gua_yu           += recipe.getHuang_gua_yu();
    this.lu_yu                  += recipe.getLu_yu();
    this.rou_                   += recipe.getRou_();
    this.qiu_dao_yu             += recipe.getQiu_dao_yu();
    this.ya_pian_yu_tou         += recipe.getYa_pian_yu_tou();
    this.ba_sha_yu_liu          += recipe.getBa_sha_yu_liu();
    this.dai_yu                 += recipe.getDai_yu();
    this.ji_yu                  += recipe.getJi_yu();
    this.you_yu                 += recipe.getYou_yu();
    this.jin_chang_yu           += recipe.getJin_chang_yu();
    this.qing_e                 += recipe.getQing_e();
    this.bao_yu                 += recipe.getBao_yu();
    this.hua_ge                 += recipe.getHua_ge();
    this.xia                    += recipe.getXia();
    this.pang_xie               += recipe.getPang_xie();
    this.xia_ren                += recipe.getXia_ren();
    this.pang_yu_tou            += recipe.getPang_yu_tou();
    this.hai_li                 += recipe.getHai_li();
    this.hai_cheng              += recipe.getHai_cheng();
    this.hai_hong               += recipe.getHai_hong();
    this.bao_gong_yu            += recipe.getBao_gong_yu();
    this.hu_gua                 += recipe.getHu_gua();
    this.dong_gua               += recipe.getDong_gua();
    this.da_bai_cai             += recipe.getDa_bai_cai();
    this.kuan_fen               += recipe.getKuan_fen();
    this.bai_luo_bo             += recipe.getBai_luo_bo();
    this.hong_luo_bo            += recipe.getHong_luo_bo();
    this.huang_dou_ya           += recipe.getHuang_dou_ya();
    this.lv_dou_ya              += recipe.getLv_dou_ya();
    this.hong_cai_jiao          += recipe.getHong_cai_jiao();
    this.cai_jiao               += recipe.getCai_jiao();
    this.huang_cai_jiao         += recipe.getHuang_cai_jiao();
    this.qing_jian_jiao         += recipe.getQing_jian_jiao();
    this.hong_jian_jiao         += recipe.getHong_jian_jiao();
    this.xiao_qing_mi_jiao      += recipe.getXiao_qing_mi_jiao();
    this.xiao_hong_mi_jiao      += recipe.getXiao_hong_mi_jiao();
    this.pao_jiao               += recipe.getPao_jiao();
    this.suan_tai               += recipe.getSuan_tai();
    this.yang_cong              += recipe.getYang_cong();
    this.huang_gua              += recipe.getHuang_gua();
    this.shi_mu_er              += recipe.getShi_mu_er();
    this.xing_bao_gu            += recipe.getXing_bao_gu();
    this.hai_xian_gu            += recipe.getHai_xian_gu();
    this.lian_ou                += recipe.getLian_ou();
    this.dong_sun               += recipe.getDong_sun();
    this.tu_dou                 += recipe.getTu_dou();
    this.jiao_bai               += recipe.getJiao_bai();
    this.wo_sun                 += recipe.getWo_sun();
    this.si_ji_dou              += recipe.getSi_ji_dou();
    this.di_gua                 += recipe.getDi_gua();
    this.shan_yao               += recipe.getShan_yao();
    this.xi_qin                 += recipe.getXi_qin();
    this.bao_cai                += recipe.getBao_cai();
    this.da_cong                += recipe.getDa_cong();
    this.chang_gan_dou          += recipe.getChang_gan_dou();
    this.xi_hong_shi            += recipe.getXi_hong_shi();
    this.si_gua                 += recipe.getSi_gua();
    this.jiu_cai                += recipe.getJiu_cai();
    this.jiu_huang              += recipe.getJiu_huang();
    this.ku_gua                 += recipe.getKu_gua();
    this.hua_cai                += recipe.getHua_cai();
    this.he_lan_dou             += recipe.getHe_lan_dou();
    this.wa_wa_cai              += recipe.getWa_wa_cai();
    this.xiang_gu_gong_wan      += recipe.getXiang_gu_gong_wan();
    this.yu_tou                 += recipe.getYu_tou();
    this.qian_ye_dou_fu         += recipe.getQian_ye_dou_fu();
    this.dou_fu                 += recipe.getDou_fu();
    this.dou_pao                += recipe.getDou_pao();
    this.lu_xiang_gan           += recipe.getLu_xiang_gan();
    this.shang_hai_qing         += recipe.getShang_hai_qing();
    this.tian_jin_bai           += recipe.getTian_jin_bai();
    this.jie_cai                += recipe.getJie_cai();
    this.sheng_cai              += recipe.getSheng_cai();
    this.kong_xin_cai           += recipe.getKong_xin_cai();
    this.cai_xin                += recipe.getCai_xin();
    this.hong_xian_cai          += recipe.getHong_xian_cai();
    this.jin_zhen_gu            += recipe.getJin_zhen_gu();
    this.qiu_kui                += recipe.getQiu_kui();
    this.bo_cai                 += recipe.getBo_cai();
    this.mu_er_cai              += recipe.getMu_er_cai();
    this.yu_hua                 += recipe.getYu_hua();
    this.yu_wan                 += recipe.getYu_wan();
    this.rou_yan                += recipe.getRou_yan();
    this.yu_mi_li               += recipe.getYu_mi_li();
    this.mian_jin               += recipe.getMian_jin();
    this.hai_dai_jie            += recipe.getHai_dai_jie();
    this.fu_zhu                 += recipe.getFu_zhu();
    this.an_chun_dan            += recipe.getAn_chun_dan();
    this.gan_cha_shu_gu         += recipe.getGan_cha_shu_gu();
    this.yu_mi                  += recipe.getYu_mi();
    this.dou_jie                += recipe.getDou_jie();
    this.pao_fa_sun_gan         += recipe.getPao_fa_sun_gan();
    this.nuo_mi                 += recipe.getNuo_mi();
    this.zheng_rou_fen          += recipe.getZheng_rou_fen();
    this.suan_miao              += recipe.getSuan_miao();
    this.mei_cai_gan            += recipe.getMei_cai_gan();
    this.suan_cai               += recipe.getSuan_cai();
    this.xiang_cai              += recipe.getXiang_cai();
    this.lao_jiang              += recipe.getLao_jiang();
    this.bing_lang_yu           += recipe.getBing_lang_yu();
    this.ping_gu                += recipe.getPing_gu();
    this.xue_li_hong            += recipe.getXue_li_hong();
    this.hai_ying_xiang_chang   += recipe.getHai_ying_xiang_chang();
    this.qie_zi                 += recipe.getQie_zi();
  }

  public void mul(int num) {
    this.wu_hua_rou             *= num;
    this.pai_gu                 *= num;
    this.rou_mo                 *= num;
    this.shou_rou_pian          *= num;
    this.shou_rou_si            *= num;
    this.zhu_xue                *= num;
    this.zhu_gan                *= num;
    this.huo_tui                *= num;
    this.lu_zhu_tou_rou         *= num;
    this.zhu_ti                 *= num;
    this.lu_da_chang            *= num;
    this.zhu_du                 *= num;
    this.pei_gen                *= num;
    this.la_rou                 *= num;
    this.zhou_zi                *= num;
    this.niu_rou                *= num;
    this.niu_gu                 *= num;
    this.niu_li_ji_rou          *= num;
    this.niu_nan                *= num;
    this.shu_niu_za             *= num;
    this.yang_rou               *= num;
    this.yang_pai               *= num;
    this.wu_xiang_ban_ya        *= num;
    this.ya_bian_tui            *= num;
    this.ya_zhen                *= num;
    this.wu_ji                  *= num;
    this.ji_mi_hua              *= num;
    this.bai_tiao_ji            *= num;
    this.ji_xiong_rou           *= num;
    this.chi_zhong              *= num;
    this.pi_pa_tui              *= num;
    this.ya_rou                 *= num;
    this.ao_er_liang_ji_pai     *= num;
    this.yan_shui_ya            *= num;
    this.kao_ya                 *= num;
    this.tu_rou                 *= num;
    this.tian_ji                *= num;
    this.cao_yu                 *= num;
    this.xiao_huang_yu          *= num;
    this.huang_gua_yu           *= num;
    this.lu_yu                  *= num;
    this.rou_                   *= num;
    this.qiu_dao_yu             *= num;
    this.ya_pian_yu_tou         *= num;
    this.ba_sha_yu_liu          *= num;
    this.dai_yu                 *= num;
    this.ji_yu                  *= num;
    this.you_yu                 *= num;
    this.jin_chang_yu           *= num;
    this.qing_e                 *= num;
    this.bao_yu                 *= num;
    this.hua_ge                 *= num;
    this.xia                    *= num;
    this.pang_xie               *= num;
    this.xia_ren                *= num;
    this.pang_yu_tou            *= num;
    this.hai_li                 *= num;
    this.hai_cheng              *= num;
    this.hai_hong               *= num;
    this.bao_gong_yu            *= num;
    this.hu_gua                 *= num;
    this.dong_gua               *= num;
    this.da_bai_cai             *= num;
    this.kuan_fen               *= num;
    this.bai_luo_bo             *= num;
    this.hong_luo_bo            *= num;
    this.huang_dou_ya           *= num;
    this.lv_dou_ya              *= num;
    this.hong_cai_jiao          *= num;
    this.cai_jiao               *= num;
    this.huang_cai_jiao         *= num;
    this.qing_jian_jiao         *= num;
    this.hong_jian_jiao         *= num;
    this.xiao_qing_mi_jiao      *= num;
    this.xiao_hong_mi_jiao      *= num;
    this.pao_jiao               *= num;
    this.suan_tai               *= num;
    this.yang_cong              *= num;
    this.huang_gua              *= num;
    this.shi_mu_er              *= num;
    this.xing_bao_gu            *= num;
    this.hai_xian_gu            *= num;
    this.lian_ou                *= num;
    this.dong_sun               *= num;
    this.tu_dou                 *= num;
    this.jiao_bai               *= num;
    this.wo_sun                 *= num;
    this.si_ji_dou              *= num;
    this.di_gua                 *= num;
    this.shan_yao               *= num;
    this.xi_qin                 *= num;
    this.bao_cai                *= num;
    this.da_cong                *= num;
    this.chang_gan_dou          *= num;
    this.xi_hong_shi            *= num;
    this.si_gua                 *= num;
    this.jiu_cai                *= num;
    this.jiu_huang              *= num;
    this.ku_gua                 *= num;
    this.hua_cai                *= num;
    this.he_lan_dou             *= num;
    this.wa_wa_cai              *= num;
    this.xiang_gu_gong_wan      *= num;
    this.yu_tou                 *= num;
    this.qian_ye_dou_fu         *= num;
    this.dou_fu                 *= num;
    this.dou_pao                *= num;
    this.lu_xiang_gan           *= num;
    this.shang_hai_qing         *= num;
    this.tian_jin_bai           *= num;
    this.jie_cai                *= num;
    this.sheng_cai              *= num;
    this.kong_xin_cai           *= num;
    this.cai_xin                *= num;
    this.hong_xian_cai          *= num;
    this.jin_zhen_gu            *= num;
    this.qiu_kui                *= num;
    this.bo_cai                 *= num;
    this.mu_er_cai              *= num;
    this.yu_hua                 *= num;
    this.yu_wan                 *= num;
    this.rou_yan                *= num;
    this.yu_mi_li               *= num;
    this.mian_jin               *= num;
    this.hai_dai_jie            *= num;
    this.fu_zhu                 *= num;
    this.an_chun_dan            *= num;
    this.gan_cha_shu_gu         *= num;
    this.yu_mi                  *= num;
    this.dou_jie                *= num;
    this.pao_fa_sun_gan         *= num;
    this.nuo_mi                 *= num;
    this.zheng_rou_fen          *= num;
    this.suan_miao              *= num;
    this.mei_cai_gan            *= num;
    this.suan_cai               *= num;
    this.xiang_cai              *= num;
    this.lao_jiang              *= num;
    this.bing_lang_yu           *= num;
    this.ping_gu                *= num;
    this.xue_li_hong            *= num;
    this.hai_ying_xiang_chang   *= num;
    this.qie_zi                 *= num;
  }

  public void mul(Double num) {
    this.wu_hua_rou             *= num;
    this.pai_gu                 *= num;
    this.rou_mo                 *= num;
    this.shou_rou_pian          *= num;
    this.shou_rou_si            *= num;
    this.zhu_xue                *= num;
    this.zhu_gan                *= num;
    this.huo_tui                *= num;
    this.lu_zhu_tou_rou         *= num;
    this.zhu_ti                 *= num;
    this.lu_da_chang            *= num;
    this.zhu_du                 *= num;
    this.pei_gen                *= num;
    this.la_rou                 *= num;
    this.zhou_zi                *= num;
    this.niu_rou                *= num;
    this.niu_gu                 *= num;
    this.niu_li_ji_rou          *= num;
    this.niu_nan                *= num;
    this.shu_niu_za             *= num;
    this.yang_rou               *= num;
    this.yang_pai               *= num;
    this.wu_xiang_ban_ya        *= num;
    this.ya_bian_tui            *= num;
    this.ya_zhen                *= num;
    this.wu_ji                  *= num;
    this.ji_mi_hua              *= num;
    this.bai_tiao_ji            *= num;
    this.ji_xiong_rou           *= num;
    this.chi_zhong              *= num;
    this.pi_pa_tui              *= num;
    this.ya_rou                 *= num;
    this.ao_er_liang_ji_pai     *= num;
    this.yan_shui_ya            *= num;
    this.kao_ya                 *= num;
    this.tu_rou                 *= num;
    this.tian_ji                *= num;
    this.cao_yu                 *= num;
    this.xiao_huang_yu          *= num;
    this.huang_gua_yu           *= num;
    this.lu_yu                  *= num;
    this.rou_                   *= num;
    this.qiu_dao_yu             *= num;
    this.ya_pian_yu_tou         *= num;
    this.ba_sha_yu_liu          *= num;
    this.dai_yu                 *= num;
    this.ji_yu                  *= num;
    this.you_yu                 *= num;
    this.jin_chang_yu           *= num;
    this.qing_e                 *= num;
    this.bao_yu                 *= num;
    this.hua_ge                 *= num;
    this.xia                    *= num;
    this.pang_xie               *= num;
    this.xia_ren                *= num;
    this.pang_yu_tou            *= num;
    this.hai_li                 *= num;
    this.hai_cheng              *= num;
    this.hai_hong               *= num;
    this.bao_gong_yu            *= num;
    this.hu_gua                 *= num;
    this.dong_gua               *= num;
    this.da_bai_cai             *= num;
    this.kuan_fen               *= num;
    this.bai_luo_bo             *= num;
    this.hong_luo_bo            *= num;
    this.huang_dou_ya           *= num;
    this.lv_dou_ya              *= num;
    this.hong_cai_jiao          *= num;
    this.cai_jiao               *= num;
    this.huang_cai_jiao         *= num;
    this.qing_jian_jiao         *= num;
    this.hong_jian_jiao         *= num;
    this.xiao_qing_mi_jiao      *= num;
    this.xiao_hong_mi_jiao      *= num;
    this.pao_jiao               *= num;
    this.suan_tai               *= num;
    this.yang_cong              *= num;
    this.huang_gua              *= num;
    this.shi_mu_er              *= num;
    this.xing_bao_gu            *= num;
    this.hai_xian_gu            *= num;
    this.lian_ou                *= num;
    this.dong_sun               *= num;
    this.tu_dou                 *= num;
    this.jiao_bai               *= num;
    this.wo_sun                 *= num;
    this.si_ji_dou              *= num;
    this.di_gua                 *= num;
    this.shan_yao               *= num;
    this.xi_qin                 *= num;
    this.bao_cai                *= num;
    this.da_cong                *= num;
    this.chang_gan_dou          *= num;
    this.xi_hong_shi            *= num;
    this.si_gua                 *= num;
    this.jiu_cai                *= num;
    this.jiu_huang              *= num;
    this.ku_gua                 *= num;
    this.hua_cai                *= num;
    this.he_lan_dou             *= num;
    this.wa_wa_cai              *= num;
    this.xiang_gu_gong_wan      *= num;
    this.yu_tou                 *= num;
    this.qian_ye_dou_fu         *= num;
    this.dou_fu                 *= num;
    this.dou_pao                *= num;
    this.lu_xiang_gan           *= num;
    this.shang_hai_qing         *= num;
    this.tian_jin_bai           *= num;
    this.jie_cai                *= num;
    this.sheng_cai              *= num;
    this.kong_xin_cai           *= num;
    this.cai_xin                *= num;
    this.hong_xian_cai          *= num;
    this.jin_zhen_gu            *= num;
    this.qiu_kui                *= num;
    this.bo_cai                 *= num;
    this.mu_er_cai              *= num;
    this.yu_hua                 *= num;
    this.yu_wan                 *= num;
    this.rou_yan                *= num;
    this.yu_mi_li               *= num;
    this.mian_jin               *= num;
    this.hai_dai_jie            *= num;
    this.fu_zhu                 *= num;
    this.an_chun_dan            *= num;
    this.gan_cha_shu_gu         *= num;
    this.yu_mi                  *= num;
    this.dou_jie                *= num;
    this.pao_fa_sun_gan         *= num;
    this.nuo_mi                 *= num;
    this.zheng_rou_fen          *= num;
    this.suan_miao              *= num;
    this.mei_cai_gan            *= num;
    this.suan_cai               *= num;
    this.xiang_cai              *= num;
    this.lao_jiang              *= num;
    this.bing_lang_yu           *= num;
    this.ping_gu                *= num;
    this.xue_li_hong            *= num;
    this.hai_ying_xiang_chang   *= num;
    this.qie_zi                 *= num;
  }

  public List<Double> flatten() {
    List<Double> flattened = new ArrayList<>();

    flattened.add(this.wu_hua_rou);
    flattened.add(this.pai_gu);
    flattened.add(this.rou_mo);
    flattened.add(this.shou_rou_pian);
    flattened.add(this.shou_rou_si);
    flattened.add(this.zhu_xue);
    flattened.add(this.zhu_gan);
    flattened.add(this.huo_tui);
    flattened.add(this.lu_zhu_tou_rou);
    flattened.add(this.zhu_ti);
    flattened.add(this.lu_da_chang);
    flattened.add(this.zhu_du);
    flattened.add(this.pei_gen);
    flattened.add(this.la_rou);
    flattened.add(this.zhou_zi);
    flattened.add(this.niu_rou);
    flattened.add(this.niu_gu);
    flattened.add(this.niu_li_ji_rou);
    flattened.add(this.niu_nan);
    flattened.add(this.shu_niu_za);
    flattened.add(this.yang_rou);
    flattened.add(this.yang_pai);
    flattened.add(this.wu_xiang_ban_ya);
    flattened.add(this.ya_bian_tui);
    flattened.add(this.ya_zhen);
    flattened.add(this.wu_ji);
    flattened.add(this.ji_mi_hua);
    flattened.add(this.bai_tiao_ji);
    flattened.add(this.ji_xiong_rou);
    flattened.add(this.chi_zhong);
    flattened.add(this.pi_pa_tui);
    flattened.add(this.ya_rou);
    flattened.add(this.ao_er_liang_ji_pai);
    flattened.add(this.yan_shui_ya);
    flattened.add(this.kao_ya);
    flattened.add(this.tu_rou);
    flattened.add(this.tian_ji);
    flattened.add(this.cao_yu);
    flattened.add(this.xiao_huang_yu);
    flattened.add(this.huang_gua_yu);
    flattened.add(this.lu_yu);
    flattened.add(this.rou_);
    flattened.add(this.qiu_dao_yu);
    flattened.add(this.ya_pian_yu_tou);
    flattened.add(this.ba_sha_yu_liu);
    flattened.add(this.dai_yu);
    flattened.add(this.ji_yu);
    flattened.add(this.you_yu);
    flattened.add(this.jin_chang_yu);
    flattened.add(this.qing_e);
    flattened.add(this.bao_yu);
    flattened.add(this.hua_ge);
    flattened.add(this.xia);
    flattened.add(this.pang_xie);
    flattened.add(this.xia_ren);
    flattened.add(this.pang_yu_tou);
    flattened.add(this.hai_li);
    flattened.add(this.hai_cheng);
    flattened.add(this.hai_hong);
    flattened.add(this.bao_gong_yu);
    flattened.add(this.hu_gua);
    flattened.add(this.dong_gua);
    flattened.add(this.da_bai_cai);
    flattened.add(this.kuan_fen);
    flattened.add(this.bai_luo_bo);
    flattened.add(this.hong_luo_bo);
    flattened.add(this.huang_dou_ya);
    flattened.add(this.lv_dou_ya);
    flattened.add(this.hong_cai_jiao);
    flattened.add(this.cai_jiao);
    flattened.add(this.huang_cai_jiao);
    flattened.add(this.qing_jian_jiao);
    flattened.add(this.hong_jian_jiao);
    flattened.add(this.xiao_qing_mi_jiao);
    flattened.add(this.xiao_hong_mi_jiao);
    flattened.add(this.pao_jiao);
    flattened.add(this.suan_tai);
    flattened.add(this.yang_cong);
    flattened.add(this.huang_gua);
    flattened.add(this.shi_mu_er);
    flattened.add(this.xing_bao_gu);
    flattened.add(this.hai_xian_gu);
    flattened.add(this.lian_ou);
    flattened.add(this.dong_sun);
    flattened.add(this.tu_dou);
    flattened.add(this.jiao_bai);
    flattened.add(this.wo_sun);
    flattened.add(this.si_ji_dou);
    flattened.add(this.di_gua);
    flattened.add(this.shan_yao);
    flattened.add(this.xi_qin);
    flattened.add(this.bao_cai);
    flattened.add(this.da_cong);
    flattened.add(this.chang_gan_dou);
    flattened.add(this.xi_hong_shi);
    flattened.add(this.si_gua);
    flattened.add(this.jiu_cai);
    flattened.add(this.jiu_huang);
    flattened.add(this.ku_gua);
    flattened.add(this.hua_cai);
    flattened.add(this.he_lan_dou);
    flattened.add(this.wa_wa_cai);
    flattened.add(this.xiang_gu_gong_wan);
    flattened.add(this.yu_tou);
    flattened.add(this.qian_ye_dou_fu);
    flattened.add(this.dou_fu);
    flattened.add(this.dou_pao);
    flattened.add(this.lu_xiang_gan);
    flattened.add(this.shang_hai_qing);
    flattened.add(this.tian_jin_bai);
    flattened.add(this.jie_cai);
    flattened.add(this.sheng_cai);
    flattened.add(this.kong_xin_cai);
    flattened.add(this.cai_xin);
    flattened.add(this.hong_xian_cai);
    flattened.add(this.jin_zhen_gu);
    flattened.add(this.qiu_kui);
    flattened.add(this.bo_cai);
    flattened.add(this.mu_er_cai);
    flattened.add(this.yu_hua);
    flattened.add(this.yu_wan);
    flattened.add(this.rou_yan);
    flattened.add(this.yu_mi_li);
    flattened.add(this.mian_jin);
    flattened.add(this.hai_dai_jie);
    flattened.add(this.fu_zhu);
    flattened.add(this.an_chun_dan);
    flattened.add(this.gan_cha_shu_gu);
    flattened.add(this.yu_mi);
    flattened.add(this.dou_jie);
    flattened.add(this.pao_fa_sun_gan);
    flattened.add(this.nuo_mi);
    flattened.add(this.zheng_rou_fen);
    flattened.add(this.suan_miao);
    flattened.add(this.mei_cai_gan);
    flattened.add(this.suan_cai);
    flattened.add(this.xiang_cai);
    flattened.add(this.lao_jiang);
    flattened.add(this.bing_lang_yu);
    flattened.add(this.ping_gu);
    flattened.add(this.xue_li_hong);
    flattened.add(this.hai_ying_xiang_chang);
    flattened.add(this.qie_zi);

    return flattened;
  }

}