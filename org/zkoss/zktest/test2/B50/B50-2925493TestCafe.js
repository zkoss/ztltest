import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2925493TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2925493TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Please check the combobox will fire onChange event after select an item and focus out of combobox
					<vbox>
						Auto-complete Combobox:
						<combobox id="combo" autodrop="true"
							onChange=\'alert(self.getValue()); if(self.getSelectedItem()!=null)msg.value=self.getSelectedItem().getLabel()\'
							constraint="no empty" />
						<label value="select:" />
						<label id="msg" />
						<hbox>
							<checkbox checked="true"
								onCheck="combo.autodrop = self.checked"
								label="auto drop popup when typing" />
							<checkbox checked="true"
								onCheck="combo.buttonVisible = self.checked" label="button visible" />
						</hbox>
					</vbox>
					<zscript>
					String[] _dict = { "abacus", "accuracy", "acuity", "adage", "afar",
							"after", "apple", "bible", "bird", "bingle", "blog", "cabane",
							"cape", "cease", "cedar", "dacron", "defacto", "definable",
							"deluxe", "each", "eager", "effect", "efficacy", "far", "far from",
							"girl", "gigantean", "giant", "home", "honest", "huge",
							"information", "inner", "jump", "jungle", "jungle fever", "kaka",
							"kale", "kame", "lamella", "lane", "lemma", "master", "maxima",
							"music", "nerve", "new", "number", "omega", "opera", "pea",
							"peace", "peaceful", "rock", "RIA", "sound", "spread", "student",
							"super", "tea", "teacher", "unit", "universe", "vector", "victory",
							"wake", "wee", "weak", "web2.0", "xeme", "yea", "yellow", "zebra",
							"zk",
				
					};
					ListModel dictModel = new SimpleListModel(_dict);
					combo.setModel(dictModel);
				</zscript>
				</zk>`,
	);
	await ClientFunction(() => {
		jq(zk.Widget.$(jq(".z-combobox")).$n("real")).focus();
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq(zk.Widget.$(jq(".z-combobox")).$n("real")))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("real"))[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("a");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("A"), "");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(jq(".z-comboitem")).is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-window-highlighted @button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("msg", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("abacus"));
});
