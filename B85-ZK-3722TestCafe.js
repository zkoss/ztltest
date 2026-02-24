import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3722TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3722.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3722TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		recordWidths();
	})();
	await ztl.waitResponse(t);
	let num_cafe = parseInt(
		await ClientFunction(() =>
			jq(".z-cell").eq(0).find("span").text().replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-cell").eq(0).offset().left,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-cell").eq(0).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafe - 1) + "]]"),
				{ dependencies: { num_cafe } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafet = parseInt(
		await ClientFunction(() =>
			jq(".z-cell").eq(1).find("span").text().replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(".z-cell").eq(1).offset().left,
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => jq(".z-cell").eq(1).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0t),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafet - 1) + "]]"),
				{ dependencies: { num_cafet } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafett = parseInt(
		await ClientFunction(() =>
			jq(".z-cell").eq(2).find("span").text().replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq(".z-cell").eq(2).offset().left,
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() => jq(".z-cell").eq(2).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0tt),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafett - 1) + "]]"),
				{ dependencies: { num_cafett } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafettt = parseInt(
		await ClientFunction(() =>
			jq(".z-cell").eq(3).find("span").text().replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq(".z-cell").eq(3).offset().left,
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() => jq(".z-cell").eq(3).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0ttt),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafettt - 1) + "]]"),
				{ dependencies: { num_cafettt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafetttt = parseInt(
		await ClientFunction(() =>
			jq(".z-cell").eq(4).find("span").text().replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => jq(".z-cell").eq(4).offset().left,
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(
		() => jq(".z-cell").eq(4).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0tttt),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafetttt - 1) + "]]"),
				{ dependencies: { num_cafetttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafettttt = parseInt(
		await ClientFunction(() =>
			jq(".z-cell").eq(5).find("span").text().replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(
		() => jq(".z-cell").eq(5).offset().left,
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(
		() => jq(".z-cell").eq(5).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0ttttt),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafettttt - 1) + "]]"),
				{ dependencies: { num_cafettttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafetttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-cell").eq(6).find("span").text().replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(
		() => jq(".z-cell").eq(6).offset().left,
	)();
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(
		() => jq(".z-cell").eq(6).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0tttttt),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafetttttt - 1) + "]]"),
				{ dependencies: { num_cafetttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafettttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(0)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(0).offset().left,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(0).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafettttttt - 1) + "]]"),
				{ dependencies: { num_cafettttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafettttttt == 4 || num_cafettttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(0).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(1)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(1).offset().left,
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(1).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2t),
		ztl.normalizeText(
			await ClientFunction(
				() => eval("pos0[monthStrArr[" + (num_cafetttttttt - 1) + "]]"),
				{ dependencies: { num_cafetttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafetttttttt == 4 || num_cafetttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(1).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(2)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(2).offset().left,
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(2).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval("pos0[monthStrArr[" + (num_cafettttttttt - 1) + "]]"),
				{ dependencies: { num_cafettttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafettttttttt == 4 || num_cafettttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(2).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(3)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(3).offset().left,
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(3).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval("pos0[monthStrArr[" + (num_cafetttttttttt - 1) + "]]"),
				{ dependencies: { num_cafetttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafetttttttttt == 4 || num_cafetttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(3).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(4)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(4).offset().left,
	)();
	let verifyVariable_cafe_3_3tttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(4).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" + (num_cafettttttttttt - 1) + "]]",
					),
				{ dependencies: { num_cafettttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafettttttttttt == 4 || num_cafettttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(4).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(5)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(5).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(5).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" + (num_cafetttttttttttt - 1) + "]]",
					),
				{ dependencies: { num_cafetttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafetttttttttttt == 4 || num_cafetttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(5).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(6)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(6).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(6).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafettttttttttttt == 4 || num_cafettttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(6).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(7)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(7).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(7).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafetttttttttttttt == 4 || num_cafetttttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(7).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(8)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(8).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(8).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafettttttttttttttt == 4 || num_cafettttttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(8).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(9)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(9).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(9).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafetttttttttttttttt == 4 || num_cafetttttttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(9).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(10)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(10).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(10).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafettttttttttttttttt == 4 || num_cafettttttttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(10).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(11)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(11).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(11).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafetttttttttttttttttt == 4 || num_cafetttttttttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(11).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(12)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(12).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(12).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (num_cafettttttttttttttttttt == 4 || num_cafettttttttttttttttttt == 5) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(12).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(13)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(13).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(13).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(13).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(14)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(14).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(14).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(14).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(15)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(15).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(15).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(15).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(16)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(16).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(16).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(16).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(17)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(17).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(17).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(17).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(18)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(18).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(18).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(18).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(19)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(19).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(19).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(19).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(20)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(20).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(20).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(20).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(21)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(21).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(21).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(21).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(22)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(22).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(22).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(22).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(23)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(23).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(23).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(23).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(24)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(24).offset().left,
	)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(24).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(24).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(25)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(25).offset().left,
	)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-grid:eq(0) .z-row-inner").eq(25).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafetttttttttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(25).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(26)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(26).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(26).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{ dependencies: { num_cafettttttttttttttttttttttttttttttttt } },
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(26).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(27)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(27).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(27).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(27).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(28)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(28).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(28).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(28).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(29)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(29).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(29).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttttttttttttttttttttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttt - 1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(29).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(30)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(30).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(30).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2tttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(30).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(31)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(31).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(31).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(31).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(32)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(32).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(32).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(32).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(33)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(33).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(33).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(33).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(34)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(34).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(34).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(34).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(35)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(35).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(35).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(35).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(36)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(36).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(36).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(36).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(37)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(37).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(37).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(37).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(38)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(38).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(38).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(38).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(39)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(39).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(39).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(39).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(40)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(40).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(40).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(40).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(41)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(41).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(41).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(41).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(42)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(42).offset().left,
		)();
	let verifyVariable_cafe_3_3tttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(42).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2tttttttttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafettttttttttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafettttttttttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(42).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafetttttttttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(0) .z-row-inner")
				.eq(43)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(43).offset().left,
		)();
	let verifyVariable_cafe_3_3ttttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-grid:eq(0) .z-row-inner").eq(43).offset().left,
		)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_2_2ttttttttttttttttttttttttttttttttttttttttttt,
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos0[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	if (
		num_cafetttttttttttttttttttttttttttttttttttttttttttttttttt == 4 ||
		num_cafetttttttttttttttttttttttttttttttttttttttttttttttttt == 5
	) {
		await t
			.expect(
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-row-inner").eq(43).width(),
					)(),
				),
			)
			.eql(ztl.normalizeText("0"));
	}
	let num_cafettttttttttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(1) .z-row td")
				.eq(1)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(1).offset().left,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(1).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos1[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttt = parseInt(
		await ClientFunction(() =>
			jq(".z-grid:eq(1) .z-row td")
				.eq(2)
				.find("span")
				.text()
				.replace(/\s/g, " "),
		)(),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4t = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(2).offset().left,
	)();
	let verifyVariable_cafe_5_5t = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(2).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4t),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos1[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafettttttttttttttttttttttttttttttttttttttttttttttttttttt =
		parseInt(
			await ClientFunction(() =>
				jq(".z-grid:eq(1) .z-row td")
					.eq(3)
					.find("span")
					.text()
					.replace(/\s/g, " "),
			)(),
		);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4tt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(3).offset().left,
	)();
	let verifyVariable_cafe_5_5tt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(3).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4tt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos1[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttttt =
		parseInt(
			await ClientFunction(() =>
				jq(".z-grid:eq(1) .z-row td")
					.eq(4)
					.find("span")
					.text()
					.replace(/\s/g, " "),
			)(),
		);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4ttt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(4).offset().left,
	)();
	let verifyVariable_cafe_5_5ttt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(4).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4ttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos1[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafettttttttttttttttttttttttttttttttttttttttttttttttttttttt =
		parseInt(
			await ClientFunction(() =>
				jq(".z-grid:eq(1) .z-row td")
					.eq(5)
					.find("span")
					.text()
					.replace(/\s/g, " "),
			)(),
		);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4tttt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(5).offset().left,
	)();
	let verifyVariable_cafe_5_5tttt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(5).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4tttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos1[monthStrArr[" +
							(num_cafettttttttttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafettttttttttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	let num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttttttt =
		parseInt(
			await ClientFunction(() =>
				jq(".z-grid:eq(1) .z-row td")
					.eq(6)
					.find("span")
					.text()
					.replace(/\s/g, " "),
			)(),
		);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4ttttt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(6).offset().left,
	)();
	let verifyVariable_cafe_5_5ttttt = await ClientFunction(
		() => jq(".z-grid:eq(1) .z-row td").eq(6).offset().left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4ttttt),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					eval(
						"pos1[monthStrArr[" +
							(num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttttttt -
								1) +
							"]]",
					),
				{
					dependencies: {
						num_cafetttttttttttttttttttttttttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		),
		ztl.normalizeText("1"),
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-column:contains(Apr):eq(0)")).$n(
							"hdfaker",
						),
					).css("visibility"),
				)(),
			),
		)
		.eql(ztl.normalizeText("collapse"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-column:contains(May):eq(0)")).$n(
							"hdfaker",
						),
					).css("visibility"),
				)(),
			),
		)
		.eql(ztl.normalizeText("collapse"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-column:contains(Apr):eq(1)")).$n(
							"hdfaker",
						),
					).css("visibility"),
				)(),
			),
		)
		.eql(ztl.normalizeText("collapse"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-column:contains(May):eq(1)")).$n(
							"hdfaker",
						),
					).css("visibility"),
				)(),
			),
		)
		.eql(ztl.normalizeText("collapse"));
});
