import { Component, ViewChild } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { SemanticModalComponent } from "ng-semantic";
import { Work } from "../_models/work";
import { WorkService } from "../_services/work.service";

@Component({
    selector: 'new-work',
    moduleId: module.id,
    templateUrl: 'new-work.component.html'
})

export class NewWorkComponent {
    newWorkForm: FormGroup;
    formSubmitted = false;

    @ViewChild("newWorkModal")
    newWorkModal: SemanticModalComponent;

    constructor(formBuilder: FormBuilder, private workService: WorkService) {
        this.newWorkForm = formBuilder.group({
            'description': new FormControl(''),
            'price': new FormControl(''),
            'status': new FormControl(''),
            'master': new FormControl('')
        });
    }

    createNewWork(): void {
        this.newWorkModal.show({inverted: true});
    }

    save(): void {
        var work = new Work(
            this.newWorkForm.value.description,
            this.newWorkForm.value.price,
            this.newWorkForm.value.status,
            this.newWorkForm.value.master
        );

        this.workService.create(work).subscribe(
            response => console.log("success"));
        this.newWorkModal.hide();
        this.newWorkForm.reset();
    }
}