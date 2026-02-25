import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1823354TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1823354TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="http://www.w3.org/1999/xhtml">
					<h:h3> [ 1823354 ] Listbox\'s content is fixed while vflex = true</h:h3>
					<h:pre>
				While user change outer window\'s height, listbox wont span it\'s content.
					</h:pre>
					<window id="win" title="test VFlex!!" sizable="true"
						width="300px" height="300px" border="normal">
						<zscript><![CDATA[
							import java.util.ArrayList;
							ArrayList list = new ArrayList();
							
							for(int i=1;i<=50;i++)
							{
								list.add("entry "+i);
							}
						]]></zscript>
						<listbox id="libox" width="250px" vflex="true">
							<listhead sizable="true">
								<listheader label="name" sort="auto"/>
							</listhead>
							<listitem forEach="\${list}" label="\${each}"/>
						</listbox>
					</window>
				</zk>`,
	);
	let originalListCellHeight_cafe = await ClientFunction(() =>
		jq(".z-listcell:eq(0)").height(),
	)();
	let winHeight_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win", true)).height(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		"30," + winHeight_cafe * 1.4,
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		"30," + (winHeight_cafe - 2),
		true,
	);

	await t.drag(
		Selector(() => jq(zk.Desktop._dt.$f("win", true))[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(originalListCellHeight_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-listcell:eq(0)").height())(),
		),
		ztl.normalizeText("1"),
	);
});
