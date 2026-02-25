import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2968752TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2968752TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			    <menubar id="menubar" width="200px">
			        <menu id="menu" label="click me"
							image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
			            <menupopup>
			                <menuitem id="menuitem"  label="Change"
								onClick=\'menu.setImage("/img/Centigrade-Widget-Icons/Briefcase-16x16.png")\' />
			            </menupopup>
			        </menu>
			    </menubar>
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$menu")).getImage(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				"/zktest/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png",
			),
		);
	await t
		.click(Selector(() => jq("$menu")[0]))
		.click(Selector(() => jq("$menuitem")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$menu")).getImage(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				"/zktest/img/Centigrade-Widget-Icons/Briefcase-16x16.png",
			),
		);
});
