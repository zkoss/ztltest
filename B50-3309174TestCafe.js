import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3309174TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3309174TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
					<ol>
						<li>Click "remove 20" button.</li>
						<li>The first of item shall be "item 20"</li>
					</ol>
				]]></html>
				<window>
					<custom-attributes org.zkoss.zul.grid.rod="false" />
					<zscript><![CDATA[
						import java.util.*;
						import org.zkoss.zul.*;
						import org.zkoss.zk.ui.event.*;
						import org.zkoss.zk.ui.event.EventListener;
						List list = new ArrayList();
						for (int i = 0; i < 200; i++)
							list.add("item " + i);
						ListModelList model = new ListModelList(list);
					]]></zscript>
					<button id="btn" label="remove 20">
						<attribute name="onClick"><![CDATA[
							for (int i = 0; i < 20; i++)
								model.remove(0);
						]]></attribute>
					</button>
					<grid id="grid" model="\${model}" width="100px" height="250px" />
				</window>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("grid", true).$n("body"))
						.find(".z-row")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("20"), "");
});
