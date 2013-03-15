
vlayout() {
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
            }
        }
    }
}