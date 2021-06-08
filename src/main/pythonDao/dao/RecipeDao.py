from pojo.Recipe import Recipe

import sqlite3

class RecipeDao:
    def __init__(self):
        path = "C:/Users/Administrator/Documents/Java/dishmanage/dish.db"
        self.conn = sqlite3.connect(path)

    def __del__(self):
        self.conn.close()

    def selectAll(self):
        return self.conn.execute("SELECT * FROM recipe;")

    def insert(self, recipe):
        self.conn.execute(
            '''INSERT INTO recipe (wu_hua_rou,pai_gu,rou_mo,shou_rou_pian,shou_rou_si,zhu_xue,zhu_gan,huo_tui,lu_zhu_tou_rou,zhu_ti,lu_da_chang,zhu_du,pei_gen,la_rou,zhou_zi,niu_rou,niu_gu,niu_li_ji_rou,niu_nan,shu_niu_za,yang_rou,yang_pai,wu_xiang_ban_ya,ya_bian_tui,ya_zhen,wu_ji,ji_mi_hua,bai_tiao_ji,ji_xiong_rou,chi_zhong,pi_pa_tui,ya_rou,ao_er_liang_ji_pai,yan_shui_ya,kao_ya,tu_rou,tian_ji,cao_yu,xiao_huang_yu,huang_gua_yu,lu_yu,rou_,qiu_dao_yu,ya_pian_yu_tou,ba_sha_yu_liu,dai_yu,ji_yu,you_yu,jin_chang_yu,qing_e,bao_yu,hua_ge,xia,pang_xie,xia_ren,pang_yu_tou,hai_li,hai_cheng,hai_hong,bao_gong_yu,hu_gua,dong_gua,da_bai_cai,kuan_fen,bai_luo_bo,hong_luo_bo,huang_dou_ya,lv_dou_ya,hong_cai_jiao,cai_jiao,huang_cai_jiao,qing_jian_jiao,hong_jian_jiao,xiao_qing_mi_jiao,xiao_hong_mi_jiao,pao_jiao,suan_tai,yang_cong,huang_gua,shi_mu_er,xing_bao_gu,hai_xian_gu,lian_ou,dong_sun,tu_dou,jiao_bai,wo_sun,si_ji_dou,di_gua,shan_yao,xi_qin,bao_cai,da_cong,chang_gan_dou,xi_hong_shi,si_gua,jiu_cai,jiu_huang,ku_gua,hua_cai,he_lan_dou,wa_wa_cai,xiang_gu_gong_wan,yu_tou,qian_ye_dou_fu,dou_fu,dou_pao,lu_xiang_gan,shang_hai_qing,tian_jin_bai,jie_cai,sheng_cai,kong_xin_cai,cai_xin,hong_xian_cai,jin_zhen_gu,qiu_kui,bo_cai,mu_er_cai,yu_hua,yu_wan,rou_yan,yu_mi_li,mian_jin,hai_dai_jie,fu_zhu,an_chun_dan,gan_cha_shu_gu,yu_mi,dou_jie,pao_fa_sun_gan,nuo_mi,zheng_rou_fen,suan_miao,mei_cai_gan,suan_cai,xiang_cai,lao_jiang,bing_lang_yu,ping_gu,xue_li_hong,hai_ying_xiang_chang,qie_zi)
            VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');'''
            %(recipe.wu_hua_rou,recipe.pai_gu,recipe.rou_mo,recipe.shou_rou_pian,recipe.shou_rou_si,recipe.zhu_xue,recipe.zhu_gan,recipe.huo_tui,recipe.lu_zhu_tou_rou,recipe.zhu_ti,recipe.lu_da_chang,recipe.zhu_du,recipe.pei_gen,recipe.la_rou,recipe.zhou_zi,recipe.niu_rou,recipe.niu_gu,recipe.niu_li_ji_rou,recipe.niu_nan,recipe.shu_niu_za,recipe.yang_rou,recipe.yang_pai,recipe.wu_xiang_ban_ya,recipe.ya_bian_tui,recipe.ya_zhen,recipe.wu_ji,recipe.ji_mi_hua,recipe.bai_tiao_ji,recipe.ji_xiong_rou,recipe.chi_zhong,recipe.pi_pa_tui,recipe.ya_rou,recipe.ao_er_liang_ji_pai,recipe.yan_shui_ya,recipe.kao_ya,recipe.tu_rou,recipe.tian_ji,recipe.cao_yu,recipe.xiao_huang_yu,recipe.huang_gua_yu,recipe.lu_yu,recipe.rou_,recipe.qiu_dao_yu,recipe.ya_pian_yu_tou,recipe.ba_sha_yu_liu,recipe.dai_yu,recipe.ji_yu,recipe.you_yu,recipe.jin_chang_yu,recipe.qing_e,recipe.bao_yu,recipe.hua_ge,recipe.xia,recipe.pang_xie,recipe.xia_ren,recipe.pang_yu_tou,recipe.hai_li,recipe.hai_cheng,recipe.hai_hong,recipe.bao_gong_yu,recipe.hu_gua,recipe.dong_gua,recipe.da_bai_cai,recipe.kuan_fen,recipe.bai_luo_bo,recipe.hong_luo_bo,recipe.huang_dou_ya,recipe.lv_dou_ya,recipe.hong_cai_jiao,recipe.cai_jiao,recipe.huang_cai_jiao,recipe.qing_jian_jiao,recipe.hong_jian_jiao,recipe.xiao_qing_mi_jiao,recipe.xiao_hong_mi_jiao,recipe.pao_jiao,recipe.suan_tai,recipe.yang_cong,recipe.huang_gua,recipe.shi_mu_er,recipe.xing_bao_gu,recipe.hai_xian_gu,recipe.lian_ou,recipe.dong_sun,recipe.tu_dou,recipe.jiao_bai,recipe.wo_sun,recipe.si_ji_dou,recipe.di_gua,recipe.shan_yao,recipe.xi_qin,recipe.bao_cai,recipe.da_cong,recipe.chang_gan_dou,recipe.xi_hong_shi,recipe.si_gua,recipe.jiu_cai,recipe.jiu_huang,recipe.ku_gua,recipe.hua_cai,recipe.he_lan_dou,recipe.wa_wa_cai,recipe.xiang_gu_gong_wan,recipe.yu_tou,recipe.qian_ye_dou_fu,recipe.dou_fu,recipe.dou_pao,recipe.lu_xiang_gan,recipe.shang_hai_qing,recipe.tian_jin_bai,recipe.jie_cai,recipe.sheng_cai,recipe.kong_xin_cai,recipe.cai_xin,recipe.hong_xian_cai,recipe.jin_zhen_gu,recipe.qiu_kui,recipe.bo_cai,recipe.mu_er_cai,recipe.yu_hua,recipe.yu_wan,recipe.rou_yan,recipe.yu_mi_li,recipe.mian_jin,recipe.hai_dai_jie,recipe.fu_zhu,recipe.an_chun_dan,recipe.gan_cha_shu_gu,recipe.yu_mi,recipe.dou_jie,recipe.pao_fa_sun_gan,recipe.nuo_mi,recipe.zheng_rou_fen,recipe.suan_miao,recipe.mei_cai_gan,recipe.suan_cai,recipe.xiang_cai,recipe.lao_jiang,recipe.bing_lang_yu,recipe.ping_gu,recipe.xue_li_hong,recipe.hai_ying_xiang_chang,recipe.qie_zi)
)
        self.conn.commit()

    def selectLast(self):
        return self.conn.execute("SELECT MAX(id) FROM recipe;")

