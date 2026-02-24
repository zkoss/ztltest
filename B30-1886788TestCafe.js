import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1886788TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1886788TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Grid rows not follow columns\'s widths when it has the auxhead component.</n:p>
				<grid height="100px">
					<auxhead>
						<auxheader label="Selecteds Items (Grid)" colspan="9"
							align="center" />
					</auxhead>
					<columns>
						<column id="column0" label="70px" width="70px" />
						<column id="column1" label="75px" width="75px" />
						<column id="column2" label="75px" width="75px" />
						<column id="column3" label="150px" width="150px" />
						<column id="column4" label="107px" width="107px" />
						<column id="column5" label="120px" width="120px" />
						<column id="column6" label="115px" width="115px" />
						<column id="column7" label="50px" width="50px" />
						<column id="column8" label="80px" width="80px" />
					</columns>
					<rows>
						<row>
							<label id="label0" value="1" />
							<label id="label1" value="2" />
							<label id="label2" value="3" />
							<label id="label3" value="4" />
							<label id="label4" value="5" />
							<label id="label5" value="6" />
							<label id="label6" value="7" />
							<label id="label7" value="8" />
							<label id="label8" value="9" />
						</row>
					</rows>
				</grid>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@row")).firstChild.$n("chdextr")).width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("$column0").width(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@row")).firstChild.$n("chdextr")).width(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("$column0").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1),
		ztl.normalizeText(verifyVariable_cafe_2_2),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(
			zk.Widget.$(jq("@row")).firstChild.nextSibling.$n("chdextr"),
		).width(),
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq("$column1").width(),
	)();
	let verifyVariable_cafe_2_2t = await ClientFunction(() =>
		jq(
			zk.Widget.$(jq("@row")).firstChild.nextSibling.$n("chdextr"),
		).width(),
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(() =>
		jq("$column1").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1t),
		ztl.normalizeText(verifyVariable_cafe_2_2t),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(
			zk.Widget.$(jq("@row")).firstChild.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq("$column2").width(),
	)();
	let verifyVariable_cafe_2_2tt = await ClientFunction(() =>
		jq(
			zk.Widget.$(jq("@row")).firstChild.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(() =>
		jq("$column2").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tt),
		ztl.normalizeText(verifyVariable_cafe_2_2tt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.$n("chdextr"),
		).width(),
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq("$column3").width(),
	)();
	let verifyVariable_cafe_2_2ttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.$n("chdextr"),
		).width(),
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(() =>
		jq("$column3").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq("$column4").width(),
	)();
	let verifyVariable_cafe_2_2tttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_3_3tttt = await ClientFunction(() =>
		jq("$column4").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tttt),
		ztl.normalizeText(verifyVariable_cafe_2_2tttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(() =>
		jq("$column5").width(),
	)();
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_3_3ttttt = await ClientFunction(() =>
		jq("$column5").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(() =>
		jq("$column6").width(),
	)();
	let verifyVariable_cafe_2_2tttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_3_3tttttt = await ClientFunction(() =>
		jq("$column6").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2tttttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_1_1ttttttt = await ClientFunction(() =>
		jq("$column7").width(),
	)();
	let verifyVariable_cafe_2_2ttttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_3_3ttttttt = await ClientFunction(() =>
		jq("$column7").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttt),
		ztl.normalizeText("5"),
	);
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_1_1tttttttt = await ClientFunction(() =>
		jq("$column8").width(),
	)();
	let verifyVariable_cafe_2_2tttttttt = await ClientFunction(() =>
		jq(
			zk.Widget.$(
				jq("@row"),
			).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.$n(
				"chdextr",
			),
		).width(),
	)();
	let verifyVariable_cafe_3_3tttttttt = await ClientFunction(() =>
		jq("$column8").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tttttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttt),
		ztl.normalizeText("5"),
	);
});
