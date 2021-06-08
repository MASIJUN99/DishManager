from os import path
import sys
sys.path.append(path.dirname(path.dirname(path.abspath(__file__))))



from dao.DishDao import DishDao
from dao.RecipeDao import RecipeDao
from pojo.Dish import Dish
from pojo.Recipe import Recipe

import pandas as pd

recipeDao = RecipeDao()
dishDao = DishDao()

filename = "C:/Users/Administrator/Documents/Java/dishmanage/src/main/pythonDao/食补定制.xls"
df = pd.read_excel(filename, "Sheet1")
ll1 = df.columns
df = df.fillna(0)

category = {
    "素菜": 0,
    "荤菜": 1,
    "半混半素": 2,
    "汤类": 3
}

idx = 1

for i in range(1, len(df[ll1[0]])):
    if df[ll1[0]][i] == 0 or df[ll1[1]][i] == 0:
        continue
    print(df[ll1[0]][i])
    print(df[ll1[1]][i])
    dish = Dish()
    dish.name = df[ll1[0]][i]
    dish.category = category[df[ll1[1]][i]]

    recipe = Recipe()
    recipe.wu_hua_rou = df[ll1[2]][i]
    recipe.pai_gu = df[ll1[3]][i]
    recipe.rou_mo = df[ll1[4]][i]
    recipe.shou_rou_pian = df[ll1[5]][i]
    recipe.shou_rou_si = df[ll1[6]][i]
    recipe.zhu_xue = df[ll1[7]][i]
    recipe.zhu_gan = df[ll1[8]][i]
    recipe.huo_tui = df[ll1[9]][i]
    recipe.lu_zhu_tou_rou = df[ll1[10]][i]
    recipe.zhu_ti = df[ll1[11]][i]
    recipe.lu_da_chang = df[ll1[12]][i]
    recipe.zhu_du = df[ll1[13]][i]
    recipe.pei_gen = df[ll1[14]][i]
    recipe.la_rou = df[ll1[15]][i]
    recipe.zhou_zi = df[ll1[16]][i]
    recipe.niu_rou = df[ll1[17]][i]
    recipe.niu_gu = df[ll1[18]][i]
    recipe.niu_li_ji_rou = df[ll1[19]][i]
    recipe.niu_nan = df[ll1[20]][i]
    recipe.shu_niu_za = df[ll1[21]][i]
    recipe.yang_rou = df[ll1[22]][i]
    recipe.yang_pai = df[ll1[23]][i]
    recipe.wu_xiang_ban_ya = df[ll1[24]][i]
    recipe.ya_bian_tui = df[ll1[25]][i]
    recipe.ya_zhen = df[ll1[26]][i]
    recipe.wu_ji = df[ll1[27]][i]
    recipe.ji_mi_hua = df[ll1[28]][i]
    recipe.bai_tiao_ji = df[ll1[29]][i]
    recipe.ji_xiong_rou = df[ll1[30]][i]
    recipe.chi_zhong = df[ll1[31]][i]
    recipe.pi_pa_tui = df[ll1[32]][i]
    recipe.ya_rou = df[ll1[33]][i]
    recipe.ao_er_liang_ji_pai = df[ll1[34]][i]
    recipe.yan_shui_ya = df[ll1[35]][i]
    recipe.kao_ya = df[ll1[36]][i]
    recipe.tu_rou = df[ll1[37]][i]
    recipe.tian_ji = df[ll1[38]][i]
    recipe.cao_yu = df[ll1[39]][i]
    recipe.xiao_huang_yu = df[ll1[40]][i]
    recipe.huang_gua_yu = df[ll1[41]][i]
    recipe.lu_yu = df[ll1[42]][i]
    recipe.rou_ = df[ll1[43]][i]
    recipe.qiu_dao_yu = df[ll1[44]][i]
    recipe.ya_pian_yu_tou = df[ll1[45]][i]
    recipe.ba_sha_yu_liu = df[ll1[46]][i]
    recipe.dai_yu = df[ll1[47]][i]
    recipe.ji_yu = df[ll1[48]][i]
    recipe.you_yu = df[ll1[49]][i]
    recipe.jin_chang_yu = df[ll1[50]][i]
    recipe.qing_e = df[ll1[51]][i]
    recipe.bao_yu = df[ll1[52]][i]
    recipe.hua_ge = df[ll1[53]][i]
    recipe.xia = df[ll1[54]][i]
    recipe.pang_xie = df[ll1[55]][i]
    recipe.xia_ren = df[ll1[56]][i]
    recipe.pang_yu_tou = df[ll1[57]][i]
    recipe.hai_li = df[ll1[58]][i]
    recipe.hai_cheng = df[ll1[59]][i]
    recipe.hai_hong = df[ll1[60]][i]
    recipe.bao_gong_yu = df[ll1[61]][i]
    recipe.hu_gua = df[ll1[62]][i]
    recipe.dong_gua = df[ll1[63]][i]
    recipe.da_bai_cai = df[ll1[64]][i]
    recipe.kuan_fen = df[ll1[65]][i]
    recipe.bai_luo_bo = df[ll1[66]][i]
    recipe.hong_luo_bo = df[ll1[67]][i]
    recipe.huang_dou_ya = df[ll1[68]][i]
    recipe.lv_dou_ya = df[ll1[69]][i]
    recipe.hong_cai_jiao = df[ll1[70]][i]
    recipe.cai_jiao = df[ll1[71]][i]
    recipe.huang_cai_jiao = df[ll1[72]][i]
    recipe.qing_jian_jiao = df[ll1[73]][i]
    recipe.hong_jian_jiao = df[ll1[74]][i]
    recipe.xiao_qing_mi_jiao = df[ll1[75]][i]
    recipe.xiao_hong_mi_jiao = df[ll1[76]][i]
    recipe.pao_jiao = df[ll1[77]][i]
    recipe.suan_tai = df[ll1[78]][i]
    recipe.yang_cong = df[ll1[79]][i]
    recipe.huang_gua = df[ll1[80]][i]
    recipe.shi_mu_er = df[ll1[81]][i]
    recipe.xing_bao_gu = df[ll1[82]][i]
    recipe.hai_xian_gu = df[ll1[83]][i]
    recipe.lian_ou = df[ll1[84]][i]
    recipe.dong_sun = df[ll1[85]][i]
    recipe.tu_dou = df[ll1[86]][i]
    recipe.jiao_bai = df[ll1[87]][i]
    recipe.wo_sun = df[ll1[88]][i]
    recipe.si_ji_dou = df[ll1[89]][i]
    recipe.di_gua = df[ll1[90]][i]
    recipe.shan_yao = df[ll1[91]][i]
    recipe.xi_qin = df[ll1[92]][i]
    recipe.bao_cai = df[ll1[93]][i]
    recipe.da_cong = df[ll1[94]][i]
    recipe.chang_gan_dou = df[ll1[95]][i]
    recipe.xi_hong_shi = df[ll1[96]][i]
    recipe.si_gua = df[ll1[97]][i]
    recipe.jiu_cai = df[ll1[98]][i]
    recipe.jiu_huang = df[ll1[99]][i]
    recipe.ku_gua = df[ll1[100]][i]
    recipe.hua_cai = df[ll1[101]][i]
    recipe.he_lan_dou = df[ll1[102]][i]
    recipe.wa_wa_cai = df[ll1[103]][i]
    recipe.xiang_gu_gong_wan = df[ll1[104]][i]
    recipe.yu_tou = df[ll1[105]][i]
    recipe.qian_ye_dou_fu = df[ll1[106]][i]
    recipe.dou_fu = df[ll1[107]][i]
    recipe.dou_pao = df[ll1[108]][i]
    recipe.lu_xiang_gan = df[ll1[109]][i]
    recipe.shang_hai_qing = df[ll1[110]][i]
    recipe.tian_jin_bai = df[ll1[111]][i]
    recipe.jie_cai = df[ll1[112]][i]
    recipe.sheng_cai = df[ll1[113]][i]
    recipe.kong_xin_cai = df[ll1[114]][i]
    recipe.cai_xin = df[ll1[115]][i]
    recipe.hong_xian_cai = df[ll1[116]][i]
    recipe.jin_zhen_gu = df[ll1[117]][i]
    recipe.qiu_kui = df[ll1[118]][i]
    recipe.bo_cai = df[ll1[119]][i]
    recipe.mu_er_cai = df[ll1[120]][i]
    recipe.yu_hua = df[ll1[121]][i]
    recipe.yu_wan = df[ll1[122]][i]
    recipe.rou_yan = df[ll1[123]][i]
    recipe.yu_mi_li = df[ll1[124]][i]
    recipe.mian_jin = df[ll1[125]][i]
    recipe.hai_dai_jie = df[ll1[126]][i]
    recipe.fu_zhu = df[ll1[127]][i]
    recipe.an_chun_dan = df[ll1[128]][i]
    recipe.gan_cha_shu_gu = df[ll1[129]][i]
    recipe.yu_mi = df[ll1[130]][i]
    recipe.dou_jie = df[ll1[131]][i]
    recipe.pao_fa_sun_gan = df[ll1[132]][i]
    recipe.nuo_mi = df[ll1[133]][i]
    recipe.zheng_rou_fen = df[ll1[134]][i]
    recipe.suan_miao = df[ll1[135]][i]
    recipe.mei_cai_gan = df[ll1[136]][i]
    recipe.suan_cai = df[ll1[137]][i]
    recipe.xiang_cai = df[ll1[138]][i]
    recipe.lao_jiang = df[ll1[139]][i]
    recipe.bing_lang_yu = df[ll1[140]][i]
    recipe.ping_gu = df[ll1[141]][i]
    recipe.xue_li_hong = df[ll1[142]][i]
    recipe.hai_ying_xiang_chang = df[ll1[143]][i]
    recipe.qie_zi = df[ll1[144]][i]
    # print(recipe)
    recipeDao.insert(recipe)

    # temp = recipeDao.selectLast()
    # recipeId = temp.lastrowid

    recipeId = idx
    dish.recipe = recipeId
    idx += 1

    dishDao.insert(dish)
    print("添加成功")

    # for j in range(2, len(ll1)):
    #     print(df[ll1[j]][i])







































