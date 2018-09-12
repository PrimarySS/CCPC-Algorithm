/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: 造模 
 * @author: XHChen   
 * @date: 2018年9月9日 下午10:15:38 
 */
package 造模;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: LowPotassium
 * @Description: 低钾造模
 * @author: XHChen
 * @date: 2018年9月9日 下午10:15:38
 */
public class LowPotassium {

	// 存储禁食不禁饮的两组数据和五组正常（原始数据）
	static Map<Integer, String> OriginalData = new HashMap<Integer, String>();

	// 存储速尿数据
	static Map<Integer, String> FurosemideData = new HashMap<Integer, String>();

	// 存储静滴数据
	static Map<Integer, String> StaticDropsData = new HashMap<Integer, String>();

	// 存储显示数据
	static Map<Integer, String> DisplayData = new HashMap<Integer, String>();

	private boolean isNormal = true; // 判断兔子开始是否正常，默认正常
	private boolean isLowPotassium = false; // 判断兔子开始是否低钾状态（禁食不禁饮），默认非低钾

	private static boolean isAnesthesia = false; // 是否麻醉
	private static double totalAnesthesia; // 麻醉剂量

	private boolean isInjectionFurosemide = false; // 判断按是否注射速尿,默认没有
	private double InFurosemideDataUrine; // 尿素的注射量

	private boolean isInjectionKcl = false; // 是否静滴kcl
	private double InjectionTime; // 静滴时间

	private static boolean isSurvive = false; // 兔子是否死亡
	private boolean isRescue = false; // 是否抢救

	/**
	 * @return isNormal
	 */
	public boolean isNormal() {
		return isNormal;
	}

	/**
	 * @param isNormal
	 *            要设置的 isNormal
	 */
	public void setNormal(boolean isNormal) {
		this.isNormal = isNormal;
	}

	/**
	 * @return isLowPotassium
	 */
	public boolean isLowPotassium() {
		return isLowPotassium;
	}

	/**
	 * @param isLowPotassium
	 *            要设置的 isLowPotassium
	 */
	public void setLowPotassium(boolean isLowPotassium) {
		this.isLowPotassium = isLowPotassium;
	}

	/**
	 * @return isAnesthesia
	 */
	public static boolean isAnesthesia() {
		return isAnesthesia;
	}

	/**
	 * @param isAnesthesia
	 *            要设置的 isAnesthesia
	 */
	public static void setAnesthesia(boolean isAnesthesia) {
		LowPotassium.isAnesthesia = isAnesthesia;
	}

	/**
	 * @return totalAnesthesia
	 */
	public static double getTotalAnesthesia() {
		return totalAnesthesia;
	}

	/**
	 * @param totalAnesthesia
	 *            要设置的 totalAnesthesia
	 */
	public static void setTotalAnesthesia(double totalAnesthesia) {
		LowPotassium.totalAnesthesia = totalAnesthesia;
	}

	/**
	 * @return isInjectionFurosemide
	 */
	public boolean isInjectionFurosemide() {
		return isInjectionFurosemide;
	}

	/**
	 * @param isInjectionFurosemide
	 *            要设置的 isInjectionFurosemide
	 */
	public void setInjectionFurosemide(boolean isInjectionFurosemide) {
		this.isInjectionFurosemide = isInjectionFurosemide;
	}

	/**
	 * @return inFurosemideDataUrine
	 */
	public double getInFurosemideDataUrine() {
		return InFurosemideDataUrine;
	}

	/**
	 * @param inFurosemideDataUrine
	 *            要设置的 inFurosemideDataUrine
	 */
	public void setInFurosemideDataUrine(double inFurosemideDataUrine) {
		InFurosemideDataUrine = inFurosemideDataUrine;
	}

	/**
	 * @return isInjectionKcl
	 */
	public boolean isInjectionKcl() {
		return isInjectionKcl;
	}

	/**
	 * @param isInjectionKcl
	 *            要设置的 isInjectionKcl
	 */
	public void setInjectionKcl(boolean isInjectionKcl) {
		this.isInjectionKcl = isInjectionKcl;
	}

	/**
	 * @return injectionTime
	 */
	public double getInjectionTime() {
		return InjectionTime;
	}

	/**
	 * @param injectionTime
	 *            要设置的 injectionTime
	 */
	public void setInjectionTime(double injectionTime) {
		InjectionTime = injectionTime;
	}

	/**
	 * @return isSurvive
	 */
	public static boolean isSurvive() {
		return isSurvive;
	}

	/**
	 * @param isSurvive
	 *            要设置的 isSurvive
	 */
	public static void setSurvive(boolean isSurvive) {
		LowPotassium.isSurvive = isSurvive;
	}

	/**
	 * @return isRescue
	 */
	public boolean isRescue() {
		return isRescue;
	}

	/**
	 * @param isRescue
	 *            要设置的 isRescue
	 */
	public void setRescue(boolean isRescue) {
		this.isRescue = isRescue;
	}

	/**
	 * 
	 * @Title: Lowpotassiumprocess
	 * @Description: 禁食不禁饮
	 * @param isLowPotassium
	 *            是否禁食不禁饮
	 * @author XHChen
	 * @date 2018年9月10日下午4:37:38
	 */
	public static void Lowpotassiumprocess(boolean isLowPotassium) {

		// 1.如果是禁食不禁饮12小时 + 麻醉的兔子
		if (isLowPotassium) {

			Integer OriginalDataKey = (int) (Math.random() * 7);
			// 调用低钾的两组数据和正常五组数据随机显示
			// System.out.println("禁食不禁饮12小时: " +
			// OriginalData.get(OriginalDataKey));
			DisplayData.put(0, OriginalData.get(OriginalDataKey));

		} else {
			Integer OriginalDataKey = (int) (Math.random() * (7 - 2) + 2);
			// 调用正常五组数据随机显示
			// System.out.println("禁食不禁饮12小时: " +
			// OriginalData.get(OriginalDataKey));
			DisplayData.put(0, OriginalData.get(OriginalDataKey));

		}

	}

	/**
	 * 
	 * @Title: isInjectionFurosemide
	 * @Description: 注射速尿
	 * @param InjectionFurosemideData
	 *            速尿注射量
	 * @author XHChen
	 * @date 2018年9月10日下午4:29:52
	 */
	public static void isInjectionFurosemide(boolean isInjectionFurosemide, double InjectionFurosemideData) {

		// 如果注射速尿
		if (isInjectionFurosemide) {
			if (InjectionFurosemideData == 10) {
				// 1.注射速尿10mg
				Integer key10mg = (int) (Math.random() * 3);

				// System.out.println("注射速尿10mg: " +
				// FurosemideData.get(key10mg));
				DisplayData.put(0, FurosemideData.get(key10mg));

			} else if (InjectionFurosemideData == 20) {
				// 2.注射速尿20mg
				Integer key20mg = (int) (Math.random() * (6 - 3) + 3);

				// System.out.println("注射速尿20mg: " +
				// FurosemideData.get(key20mg));
				DisplayData.put(0, FurosemideData.get(key20mg));

			} else if (InjectionFurosemideData == 40) {
				// 3.注射速尿40mg
				Integer key40mg = (int) (Math.random() * (14 - 6) + 6);

				// System.out.println("注射速尿40mg: " +
				// FurosemideData.get(key40mg));
				DisplayData.put(0, FurosemideData.get(key40mg));

			} else if (InjectionFurosemideData == 60) {
				// 4.注射速尿60mg
				// System.out.println("注射速尿60mg: " + FurosemideData.get(14));
				DisplayData.put(0, FurosemideData.get(14));

			}
		}

	}

	/**
	 * 
	 * @Title: StaticDropsKcl
	 * @Description: 静滴kcl
	 * @param isTime
	 *            注射时间
	 * @author XHChen
	 * @date 2018年9月10日下午5:23:47
	 */
	public static void StaticDropsKcl(boolean isInjectionKcl, double InjectionTime) {

		Integer DropsKey = null;

		// 2.判断是否注射kcl
		if (isInjectionKcl) {
			// .是
			if (InjectionTime <= 10) {
				// .是，调用正常的五组数据随机显示
				DropsKey = (int) (Math.random() * 2);

				// System.out.println("静滴kcl时间5-10(min): " +
				// StaticDropsData.get(DropsKey));
				DisplayData.put(0, StaticDropsData.get(DropsKey));

			} else if (InjectionTime <= 20) {
				DropsKey = (int) (Math.random() * (5 - 2) + 2);

				// System.out.println("静滴kcl时间10-20(min): " +
				// StaticDropsData.get(DropsKey));
				DisplayData.put(0, StaticDropsData.get(DropsKey));

			} else if (InjectionTime <= 30) {

				// System.out.println("静滴kcl时间20-30(min): " +
				// StaticDropsData.get(5));

				DisplayData.put(0, StaticDropsData.get(5));

			}
		}

	}

	/**
	 * 
	 * @Title: InAnesthesia
	 * @Description: 麻醉
	 * @author XHChen
	 * @date 2018年9月11日上午3:16:24
	 */
	public static void InAnesthesia(boolean Anesthesia, double AesthesiaNum) {

		// 是否麻醉
		if (Anesthesia) {
			// 是
			// 是否已经麻醉过
			if (isAnesthesia) {
				// 是
				// 兔子死亡
				isSurvive = true; // 标记兔子死亡
				System.out.println("多次麻醉，兔子死亡！");
			} else {
				totalAnesthesia = AesthesiaNum; // 保存麻醉剂量
				isAnesthesia = true; // 标记已经麻醉过
			}
		}

	}

	/**
	 * 
	 * @Title: weighing
	 * @Description: 判断是否麻醉成功
	 * @param weigh
	 *            兔子重量
	 * @param LocalAnesthesia
	 *            麻醉量ml
	 * @author XHChen
	 * @date 2018年9月11日上午12:59:05
	 */
	public static void weighing(int weigh, int LocalAnesthesia) {

		// 兔子是否死亡
		if (!isSurvive) {
			// 否
			// 如果兔子已经麻醉
			if (isAnesthesia) {
				// 判断麻醉剂量和重量的比值
				if (weigh == LocalAnesthesia) {
					// 1.比例=1：1，成功
					System.out.println("麻醉成功！");
				} else if (weigh < LocalAnesthesia) {
					// 3.比例<1:1,清醒
					System.out.println("麻醉剂量过少，兔子清醒！");
				} else {
					// 2.比例>1：1，死亡
					isSurvive = true; // 标记兔子死亡
					System.out.println("麻醉过度，兔子死亡！");
				}
			} else {
				System.out.println("兔子未麻醉！");
			}
		} else {
			// 是
			isSurvive = true; // 标记兔子死亡
			System.out.println("称重前兔子已死亡！");
		}

	}

	/**
	 * 
	 * @Title: printDisplayData
	 * @Description: 显示实时数据
	 * @author XHChen
	 * @date 2018年9月11日下午7:52:49
	 */
	public static void printDisplayData() {

		System.out.println(DisplayData.get(0));

	}

	/**
	 * 
	 * @Title: withoutFastDates
	 * @Description: 禁食不禁饮低钾数据
	 * @author XHChen
	 * @date 2018年9月10日上午12:44:21
	 */
	public static void OriginalDates() {

		// 禁食不禁饮低钾数据
		OriginalData.put(0, "血钾浓度 = 3.38(mmol/L) 尿液pH = 6.7");
		OriginalData.put(1, "血钾浓度 = 3.02(mmol/L) 尿液pH = 6.2");

		// 正常数据
		OriginalData.put(2, "血钾浓度 = 4.28(mmol/L) 尿液pH = 7.7");
		OriginalData.put(3, "血钾浓度 = 4.07(mmol/L) 尿液pH = 7.0");
		OriginalData.put(4, "血钾浓度 = 5.02(mmol/L) 尿液pH = 7.2");
		OriginalData.put(5, "血钾浓度 = 3.67(mmol/L) 尿液pH = 6.8");
		OriginalData.put(6, "血钾浓度 = 3.88(mmol/L) 尿液pH = 7.4");

	}

	/**
	 * 
	 * @Title: FurosemideDatas
	 * @Description: 速尿数据
	 * @author XHChen
	 * @date 2018年9月10日上午1:40:26
	 */
	public static void FurosemideDatas() {

		// 速尿10mg
		FurosemideData.put(0, "血钾浓度 = 5.61(mmol/L) 尿液pH = 6.7");
		FurosemideData.put(1, "血钾浓度 = 3.13(mmol/L) 尿液pH = 6.4");
		FurosemideData.put(2, "血钾浓度 = 2.72(mmol/L) 尿液pH = 6.4");

		// 速尿20mg
		FurosemideData.put(3, "血钾浓度 = 2.67(mmol/L) 尿液pH = 6.5");
		FurosemideData.put(4, "血钾浓度 = 2.28(mmol/L) 尿液pH = 6.1");
		FurosemideData.put(5, "血钾浓度 = 2.89(mmol/L) 尿液pH = 6.7");

		// 速尿40mg
		FurosemideData.put(6, "血钾浓度 = 3.85(mmol/L) 尿液pH = 6.7");
		FurosemideData.put(7, "血钾浓度 = 2.92(mmol/L) 尿液pH = 6.4");
		FurosemideData.put(8, "血钾浓度 = 2.9(mmol/L) 尿液pH = 6.8");
		FurosemideData.put(9, "血钾浓度 = 3.46(mmol/L) 尿液pH = 6.5");
		FurosemideData.put(10, "血钾浓度 = 3.12(mmol/L) 尿液pH = 6.3");
		FurosemideData.put(11, "血钾浓度 = 3.5(mmol/L) 尿液pH = 6.5");
		FurosemideData.put(12, "血钾浓度 = 3.93(mmol/L) 尿液pH = 6.7");
		FurosemideData.put(13, "血钾浓度 = 2.35(mmol/L) 尿液pH = 6.4");

		// 速尿60mg
		FurosemideData.put(14, "血钾浓度 = 3.11(mmol/L) 尿液pH = 6.6");

	}

	/**
	 * 
	 * @Title: StaticDropsDatas
	 * @Description: 静滴数据
	 * @author XHChen
	 * @date 2018年9月10日下午5:32:52
	 */
	public static void StaticDropsDatas() {

		// 静滴0.3%Kcl(5-10分钟)
		StaticDropsData.put(0, "血钾浓度 = 3.11(mmol/L) 尿液pH = 7");
		StaticDropsData.put(1, "血钾浓度 = 3.68(mmol/L) 尿液pH = 7.1");

		// 静滴0.3%Kcl(10-20分钟)
		StaticDropsData.put(2, "血钾浓度 = 4.71(mmol/L) 尿液pH = 7.23");
		StaticDropsData.put(3, "血钾浓度 = 5.1(mmol/L) 尿液pH = 7.3");
		StaticDropsData.put(4, "血钾浓度 = 4.76(mmol/L) 尿液pH = 7");

		// 静滴0.3%Kcl(20-30分钟)
		StaticDropsData.put(5, "血钾浓度 = 6.5(mmol/L) 尿液pH = 7.2");

	}

	/**
	 * 
	 * @Title: main
	 * @Description: 主测函数
	 * @param args
	 *            void
	 * @author XHChen
	 * @date 2018年9月9日下午10:46:32
	 */
	public static void main(String[] args) {

		// Scanner input = new Scanner(System.in);

		// 加载禁食不禁饮低钾数据
		OriginalDates();

		// 加载速尿数据
		FurosemideDatas();

		// 加载静滴数据
		StaticDropsDatas();

		// 情况1
		Lowpotassiumprocess(true); // 禁食不禁饮

		printDisplayData(); // 显示此时数据

		InAnesthesia(true, 6); // 麻醉

		weighing(6, 6); // 称重

		isInjectionFurosemide(true, 20); // 注射速尿

		printDisplayData(); // 显示此时数据

		StaticDropsKcl(true, 16); // 静滴kcl

		printDisplayData(); // 显示此时数据

		// 情况2
		Lowpotassiumprocess(true); // 禁食不禁饮

		printDisplayData(); // 显示此时数据

		isInjectionFurosemide(true, 20); // 注射速尿

		printDisplayData(); // 显示此时数据

		InAnesthesia(true, 6); // 麻醉

		weighing(6, 6); // 称重

		StaticDropsKcl(true, 16); // 静滴kcl

		printDisplayData(); // 显示此时数据

		// 实验开始
		// LowPotassium lp = new LowPotassium();
		//
		// System.out.print("兔子是否正常(true/false)： ");
		// boolean flagNormal = input.nextBoolean();
		// lp.setNormal(flagNormal); // 不正常
		//
		// if (!lp.isNormal()) {
		// System.out.print("兔子是否禁食不禁饮(true/false)： ");
		// boolean flagLowPotassium = input.nextBoolean();
		// lp.setLowPotassium(flagLowPotassium); // 是否禁食不禁饮
		// Lowpotassiumprocess(lp.isLowPotassium()); // 禁食不禁饮，显示原始数据
		// // 称重
		// System.out.print("兔子重量和麻醉量： ");
		// int weigh = input.nextInt();
		// int LocalAnesthesia = input.nextInt();
		// int sinal = weighing(weigh, LocalAnesthesia);
		// if (sinal == 1) {
		// // 麻醉成功
		// System.out.print("兔子是否注射速尿(true/false)： ");
		// boolean flagInjectionFurosemide = input.nextBoolean();
		// lp.setInjectionFurosemide(flagInjectionFurosemide);
		//
		// // 注射速尿
		// if (lp.isInjectionFurosemide()) {
		// System.out.print("兔子注射速尿量(10mg/20mg/40mg/60mg)： ");
		// double flagInFurosemideDataUrin = input.nextDouble();
		// lp.setInFurosemideDataUrine(flagInFurosemideDataUrin); //
		// 注射速尿量(10mg/20mg/40mg/60mg)
		//
		// isInjectionFurosemide(lp.getInFurosemideUrine()); // 显示速尿数据
		// } else {
		// Lowpotassiumprocess(lp.isLowPotassium()); // 禁食不禁饮 +
		// // 麻醉，显示原始数据
		// }
		//
		// System.out.print("是否抢救兔子(true/false)： ");
		// boolean flagisRescue = input.nextBoolean();
		// if (flagisRescue) {
		// double flagisTime = input.nextDouble();
		// lp.setIsTime(flagisTime);
		// StaticDropsKcl(lp.getIsTime()); // 静滴kcl
		//
		// } else {
		// System.out.println("实验结束。");
		// }
		//
		// } else if (sinal == 0) {
		// // 兔子清醒
		// System.out.println("兔子清醒，麻醉失败。");
		//
		// Lowpotassiumprocess(lp.isLowPotassium()); // 禁食不禁饮 + 麻醉，显示原始数据
		// } else {
		// // 兔子死亡
		// System.out.println("兔子死亡，实验结束。");
		// Lowpotassiumprocess(lp.isLowPotassium()); // 禁食不禁饮 + 麻醉，显示原始数据
		//
		// }
		// } else {
		// Lowpotassiumprocess(lp.isLowPotassium()); // 显示正常数据
		// }
		//
	}

}
