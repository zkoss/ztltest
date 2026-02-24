import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1807414TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1807414TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test of setModel with declared content" border="normal">
  <label value="Version: \${desktop.webApp.version}"/>
  <zscript><![CDATA[
  import org.zkoss.util.Pair;

  List infos = new LinkedList();
  for (int j = 0; j < 5; ++j) {
    infos.add(new Pair("A" + j, "B" + j));
  }
  ListModelList model = new ListModelList(infos);
  ]]></zscript>

  <grid id="x" >
  <rows>
  <row>
  <textbox value="ABC"/><textbox value="DEF"/><textbox value="YYY"/>
  </row>
  </rows>
  </grid>
  <zscript>
  x.setModel(model);
  </zscript>

  <separator/>

  <listbox id="y">
  <listitem>
  <listcell>
  <textbox value="A"/>
  </listcell>
  <listcell>
  <textbox value="B"/>
  </listcell>
  </listitem>
  </listbox>
  <zscript>
  y.setModel(model);
  </zscript>
</window>`,
	);
	let textR_cafe = await ClientFunction(() =>
		jq("@row").eq(0).find("@label").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textR_cafe))
		.contains(ztl.normalizeText("A0"), "");
	await t
		.expect(ztl.normalizeText(textR_cafe))
		.contains(ztl.normalizeText("B0"), "");
	let textR_cafet = await ClientFunction(() =>
		jq("@row").eq(1).find("@label").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textR_cafet))
		.contains(ztl.normalizeText("A1"), "");
	await t
		.expect(ztl.normalizeText(textR_cafet))
		.contains(ztl.normalizeText("B1"), "");
	let textR_cafett = await ClientFunction(() =>
		jq("@row").eq(2).find("@label").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textR_cafett))
		.contains(ztl.normalizeText("A2"), "");
	await t
		.expect(ztl.normalizeText(textR_cafett))
		.contains(ztl.normalizeText("B2"), "");
	let textR_cafettt = await ClientFunction(() =>
		jq("@row").eq(3).find("@label").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textR_cafettt))
		.contains(ztl.normalizeText("A3"), "");
	await t
		.expect(ztl.normalizeText(textR_cafettt))
		.contains(ztl.normalizeText("B3"), "");
	let textR_cafetttt = await ClientFunction(() =>
		jq("@row").eq(4).find("@label").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textR_cafetttt))
		.contains(ztl.normalizeText("A4"), "");
	await t
		.expect(ztl.normalizeText(textR_cafetttt))
		.contains(ztl.normalizeText("B4"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("x", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	let textL_cafe = await ClientFunction(() =>
		jq("@listitem").eq(0).find("div").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textL_cafe))
		.contains(ztl.normalizeText("A0"), "");
	await t
		.expect(ztl.normalizeText(textL_cafe))
		.contains(ztl.normalizeText("B0"), "");
	let textL_cafet = await ClientFunction(() =>
		jq("@listitem").eq(1).find("div").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textL_cafet))
		.contains(ztl.normalizeText("A1"), "");
	await t
		.expect(ztl.normalizeText(textL_cafet))
		.contains(ztl.normalizeText("B1"), "");
	let textL_cafett = await ClientFunction(() =>
		jq("@listitem").eq(2).find("div").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textL_cafett))
		.contains(ztl.normalizeText("A2"), "");
	await t
		.expect(ztl.normalizeText(textL_cafett))
		.contains(ztl.normalizeText("B2"), "");
	let textL_cafettt = await ClientFunction(() =>
		jq("@listitem").eq(3).find("div").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textL_cafettt))
		.contains(ztl.normalizeText("A3"), "");
	await t
		.expect(ztl.normalizeText(textL_cafettt))
		.contains(ztl.normalizeText("B3"), "");
	let textL_cafetttt = await ClientFunction(() =>
		jq("@listitem").eq(4).find("div").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(textL_cafetttt))
		.contains(ztl.normalizeText("A4"), "");
	await t
		.expect(ztl.normalizeText(textL_cafetttt))
		.contains(ztl.normalizeText("B4"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("y", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
});
