import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3031562TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3031562TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<label
				value="The AA and BB should be in the same line, if iin different line, it\'s wrong" />
			<hbox id="hbox">
				<div>AA</div>
				<div>BB</div>
			</hbox>

			<label id="msg" style="color:red;">
				<attribute name="onCreate">
				if ("default".equals(hbox.getOrient()))
					self.setValue("The hbox\'s mold should be horizontal, not "
							+ hbox.getOrient());
				</attribute>
			</label>
		</zk>`,
	);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("msg", true).getValue(),
				)(),
			),
		);
});
