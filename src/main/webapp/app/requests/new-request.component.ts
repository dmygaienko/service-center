import { Component, ViewChild } from "@angular/core";
import { SemanticModalComponent } from "ng-semantic";
import { FormGroup, FormBuilder, FormControl } from "@angular/forms";

@Component({
    selector: 'new-request-modal',
    moduleId: module.id,
    templateUrl: 'new-request.component.html'
})

export class NewRequestComponent {
    newRequestForm: FormGroup;
    formSubmitted = false;

    @ViewChild("modal")
    newRequestModal: SemanticModalComponent;

    constructor(formBuilder: FormBuilder) {
        this.newRequestForm = formBuilder.group({
            'client': new FormControl(''),
            'type': new FormControl(''),
            'status': new FormControl(''),
            'productDescription': new FormControl('')
        });
    }

    createNewRequest(): void {
        this.newRequestModal.show({inverted: true});
    }

    save(): void {
        var l;
        this.newRequestModal.hide();
    }
}