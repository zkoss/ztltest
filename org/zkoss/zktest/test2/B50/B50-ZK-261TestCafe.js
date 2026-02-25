import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-261TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-261TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<zscript><![CDATA[
					import java.io.*;
					int cnt = 0;
				]]></zscript>
				<div>1. Click "Clone" Button.</div>
				<div>2. Click the 2nd "Check Panelchildren" Button. You shall see the answer be true. Otherwise it is a bug.</div>
				<vlayout id="vb">
					<button label="Clone">
						<attribute name="onClick"><![CDATA[
							ByteArrayOutputStream boa = new ByteArrayOutputStream();
							new ObjectOutputStream(boa).writeObject(panel);
							byte[] bs = boa.toByteArray();
							Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
							l.setId("dst" + ++cnt);
							vb.appendChild(new Label(bs.length + " bytes copied"));
							vb.appendChild(l);
						]]></attribute>
					</button>
					<panel id="panel" title="Panel">
						<panelchildren>
							<button label="Check Panelchildren">
								<attribute name="onClick"><![CDATA[
									Component pl = self.getParent().getParent().getPanelchildren();
									alert(pl + ", Same parent: " + (pl == self.parent));
								]]></attribute>
							</button>
						</panelchildren>
					</panel>
				</vlayout>
			</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[2]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-messagebox").find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("true"), "The answer should be true");
});
