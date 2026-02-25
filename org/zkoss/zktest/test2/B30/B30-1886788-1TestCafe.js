import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1886788-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1886788-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Grid rows not follow columns\'s widths when it has the auxhead component.(This example also apply to listbox)</n:p>
				<listbox>
					<auxhead>
						<auxheader label="Selecteds Items (Listbox)" colspan="9"
							align="center" />
					</auxhead>
					<listhead>
						<listheader id="header0" label="70px" width="70px" />
						<listheader id="header1" label="75px" width="75px" />
						<listheader id="header2" label="75px" width="75px" />
						<listheader id="header3" label="150px" width="150px" />
						<listheader id="header4" label="107px" width="107px" />
						<listheader id="header5" label="120px" width="120px" />
						<listheader id="header6" label="115px" width="115px" />
						<listheader id="header7" label="50px" width="50px" />
						<listheader id="header8" label="80px" width="90px" />
					</listhead>
					<listitem>
						<listcell id="cell0" label="1" />
						<listcell id="cell1" label="2" />
						<listcell id="cell2" label="3" />
						<listcell id="cell3" label="4" />
						<listcell id="cell4" label="5" />
						<listcell id="cell5" label="6" />
						<listcell id="cell6" label="7" />
						<listcell id="cell7" label="8" />
						<listcell id="cell8" label="9" />
					</listitem>
				</listbox>
		</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("$cell0").width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("$header0").width(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq("$cell0").width(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("$header0").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1),
		ztl.normalizeText(verifyVariable_cafe_2_2),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq("$cell1").width(),
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq("$header1").width(),
	)();
	let verifyVariable_cafe_2_2t = await ClientFunction(() =>
		jq("$cell1").width(),
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(() =>
		jq("$header1").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1t),
		ztl.normalizeText(verifyVariable_cafe_2_2t),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq("$cell2").width(),
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq("$header2").width(),
	)();
	let verifyVariable_cafe_2_2tt = await ClientFunction(() =>
		jq("$cell2").width(),
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(() =>
		jq("$header2").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tt),
		ztl.normalizeText(verifyVariable_cafe_2_2tt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq("$cell3").width(),
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq("$header3").width(),
	)();
	let verifyVariable_cafe_2_2ttt = await ClientFunction(() =>
		jq("$cell3").width(),
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(() =>
		jq("$header3").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq("$cell4").width(),
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq("$header4").width(),
	)();
	let verifyVariable_cafe_2_2tttt = await ClientFunction(() =>
		jq("$cell4").width(),
	)();
	let verifyVariable_cafe_3_3tttt = await ClientFunction(() =>
		jq("$header4").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tttt),
		ztl.normalizeText(verifyVariable_cafe_2_2tttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq("$cell5").width(),
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(() =>
		jq("$header5").width(),
	)();
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(() =>
		jq("$cell5").width(),
	)();
	let verifyVariable_cafe_3_3ttttt = await ClientFunction(() =>
		jq("$header5").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(() =>
		jq("$cell6").width(),
	)();
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(() =>
		jq("$header6").width(),
	)();
	let verifyVariable_cafe_2_2tttttt = await ClientFunction(() =>
		jq("$cell6").width(),
	)();
	let verifyVariable_cafe_3_3tttttt = await ClientFunction(() =>
		jq("$header6").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2tttttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(() =>
		jq("$cell7").width(),
	)();
	let verifyVariable_cafe_1_1ttttttt = await ClientFunction(() =>
		jq("$header7").width(),
	)();
	let verifyVariable_cafe_2_2ttttttt = await ClientFunction(() =>
		jq("$cell7").width(),
	)();
	let verifyVariable_cafe_3_3ttttttt = await ClientFunction(() =>
		jq("$header7").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(() =>
		jq("$cell8").width(),
	)();
	let verifyVariable_cafe_1_1tttttttt = await ClientFunction(() =>
		jq("$header8").width(),
	)();
	let verifyVariable_cafe_2_2tttttttt = await ClientFunction(() =>
		jq("$cell8").width(),
	)();
	let verifyVariable_cafe_3_3tttttttt = await ClientFunction(() =>
		jq("$header8").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tttttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttt),
		ztl.normalizeText("5"),
	);
});
