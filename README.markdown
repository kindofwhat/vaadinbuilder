#vaadinbuilder: a Groovy Builder for Vaadin
Goal is to make the creation of vaadin GUIs as clutterless as possible:

An example (taken from the sister project https://github.com/kindofwhat/jcrweb.git)


    builder.vlayout() {
			tabsheet() {
				vlayout(caption:'Login') {
					gridlayout('loginGrid', caption:'Login', columns:2, width: 600) {
						label( caption:'URL')
							textfield('url', model:'url')
						label(caption:'Name'); textfield('username', model:'username')
						label(caption:'Password'); textfield('password', secret:true, model:'password')
						label(); button('login', caption:'Login', onclick: {this.login()})
						label(); button('logout', caption:'Logout', onclick: {this.logout()}, enabled:false)
					}
					hlayout() {
						label('welcomeLabel')
					}
				} 
				hlayout('browser', caption:'Browser', readOnly:true, width:1100) {
					tree('browserTree', immediate:true, caption:'Browser Tree', width:200, onchange: { e-> /*println e.source;*/ this.displayNode()})
					hlayout('nodeDetails', visible:false) {
						jcrtable('nodeTable', width:800, caption:'Node Properties', tableFieldFactory: new JcrTableFieldFactory(),editable:true) 
					}
				}
			}
			label('messageLabel', contentMode:Label.CONTENT_PREFORMATTED)
		}
		
		
Current state: not all widgets implemented

