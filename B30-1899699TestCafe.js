import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1899699TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1899699TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk:window xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:zk="http://www.zkoss.org/2005/zul"
		xmlns:a="http://www.zkoss.org/2005/zk/annotation"
		xsi:schemaLocation="http://www.zkoss.org/2005/zul\nhttp://www.zkoss.org/2005/zul/zul.xsd "
		id="prova" border="normal" width="100%" height="250"
		contentStyle="position:relative;">
		<zk:label value="Check column size in listbox is correct"></zk:label>
		<zk:listbox id="vociPreventivoList" rows="10" width="100%">
			<zk:listhead>
				<zk:listheader width="20%" label="Descrizione (20%)"
					align="right" />
				<zk:listheader width="10%" label="Quantita(10" align="right" />
				<zk:listheader width="20%" label="Imponibile (20%)"
					align="right" />
				<zk:listheader width="20%" label="Iva(20%)" align="right" />
				<zk:listheader width="20%" label="Totale (20%)" align="right" />
			</zk:listhead>
			<zk:listitem>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
			</zk:listitem>
			<zk:listitem>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
			</zk:listitem>
		</zk:listbox>
	</zk:window>`,
	);
	let fullwidth_cafe = await ClientFunction(() => jq("@listhead").width())();
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@listheader").eq(0).width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@listheader").eq(0).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_1_1 * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq("@listheader").eq(1).width(),
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq("@listheader").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("10"),
		ztl.normalizeText((verifyVariable_cafe_1_1t * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq("@listheader").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq("@listheader").eq(2).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_1_1tt * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq("@listheader").eq(3).width(),
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq("@listheader").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_1_1ttt * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq("@listheader").eq(4).width(),
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq("@listheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_1_1tttt * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(0).width(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(0).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_3_3 * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2t = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(1).width(),
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("10"),
		ztl.normalizeText((verifyVariable_cafe_3_3t * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2tt = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(2).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_3_3tt * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2ttt = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(3).width(),
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_3_3ttt * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2tttt = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(4).width(),
	)();
	let verifyVariable_cafe_3_3tttt = await ClientFunction(() =>
		jq("@listitem:eq(0) @listcell").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText((verifyVariable_cafe_3_3tttt * 100) / fullwidth_cafe),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(0).width(),
	)();
	let verifyVariable_cafe_3_3ttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(0).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText(
			(verifyVariable_cafe_3_3ttttt * 100) / fullwidth_cafe,
		),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2tttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(1).width(),
	)();
	let verifyVariable_cafe_3_3tttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("10"),
		ztl.normalizeText(
			(verifyVariable_cafe_3_3tttttt * 100) / fullwidth_cafe,
		),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2ttttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3ttttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(2).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText(
			(verifyVariable_cafe_3_3ttttttt * 100) / fullwidth_cafe,
		),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2tttttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(3).width(),
	)();
	let verifyVariable_cafe_3_3tttttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText(
			(verifyVariable_cafe_3_3tttttttt * 100) / fullwidth_cafe,
		),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_2_2ttttttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(4).width(),
	)();
	let verifyVariable_cafe_3_3ttttttttt = await ClientFunction(() =>
		jq("@listitem:eq(1) @listcell").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText(
			(verifyVariable_cafe_3_3ttttttttt * 100) / fullwidth_cafe,
		),
		ztl.normalizeText("2"),
	);
});
