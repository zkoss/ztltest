import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1752477TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1752477TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="checkbox demo" border="normal">
			See if the position of combobox image is right.
				<groupbox mold="3d" height="100%" width="100%">
					<caption label="test something" />
					Combobox:
					<vbox>
						<combobox id="cb1">
							<comboitem label="Simple and Rich"/>
							<comboitem label="Cool!"/>
							<comboitem label="Thumbs Up!"/>
						</combobox>
						<combobox id="cb2">
							<comboitem label="Simple and Rich"
							description="The simplest way to make Web applications rich"/>
							<comboitem label="Cool!"
							description="The coolest technology"/>
							<comboitem label="Ajax and RIA"
							description="Rich Internet Application by Ajax"/>
						</combobox>
						<combobox  id="cb3">
							<comboitem label="Simple and Rich" image="/test2/img/coffee.gif"
							description="The simplest way to make Web applications rich"/>
							<comboitem label="Cool!" image="/test2/img/corner.gif"
							description="The coolest technology"/>
							<comboitem label="Ajax and RIA" image="/test2/img/cubfirs.gif"
							description="Rich Internet Application by Ajax"/>
						</combobox>
			
						<separator bar="true"/>
						Auto-complete:
						<combobox autodrop="true"  id="cb4"/>
						<zscript>
				String[] _dict = { 
					"abacus", "accuracy", "acuity", "adage", "afar", "after", "apple",
					"bible", "bird", "bingle", "blog",
					"cabane", "cape", "cease", "cedar",
					"dacron", "defacto", "definable", "deluxe",
					"each", "eager", "effect", "efficacy",
					"far", "far from",
					"girl", "gigantean", "giant",
					"home", "honest", "huge",
					"information", "inner",
					"jump", "jungle", "jungle fever",
					"kaka", "kale", "kame",
					"lamella", "lane", "lemma",
					"master", "maxima", "music",
					"nerve", "new", "number",
					"omega", "opera",
					"pea", "peace", "peaceful",
					"rock", "RIA",
					"sound", "spread", "student", "super",
					"tea", "teacher",
					"unit", "universe",
					"vector", "victory",
					"wake", "wee", "weak", "web2.0",
					"xeme",
					"yea", "yellow",
					"zebra", "zk",
					
				};
				 ListModel dictModel= new SimpleListModel(_dict);
				 cb4.setModel(dictModel);
				</zscript>
						<hbox>
							<checkbox checked="true" onCheck="combo.autodrop = self.checked"
							label="auto drop popup when typing"/>
							<checkbox checked="true" onCheck="combo.buttonVisible = self.checked"
							label="button visible"/>
						</hbox>
					</vbox>
				</groupbox>
			</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb1", true).$n()).outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n()).outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb4", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n()).outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n("btn")).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb1", true).$n("btn")).outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n("btn")).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n("btn")).outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb4", true).$n("btn")).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n("btn")).outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true)).find("i").outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb1", true)).find("i").outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true)).find("i").outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true)).find("i").outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb4", true)).find("i").outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true)).find("i").outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n()).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb1", true).$n()).outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n()).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n()).outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb4", true).$n()).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n()).outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n("btn")).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb1", true).$n("btn")).outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n("btn")).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true).$n("btn")).outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb4", true).$n("btn")).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true).$n("btn")).outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true)).find("i").outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb1", true)).find("i").outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true)).find("i").outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb2", true)).find("i").outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb4", true)).find("i").outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb3", true)).find("i").outerHeight(),
				)(),
			),
		);
});
