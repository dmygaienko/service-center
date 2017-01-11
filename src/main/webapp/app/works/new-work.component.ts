import {Component, ViewChild, AfterViewInit, ElementRef, Input, NgZone, EventEmitter, Output} from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { SemanticModalComponent } from "ng-semantic";
import { Work } from "../_models/work";
import { WorkService } from "../_services/work.service";
import { UserInfo } from "../_models/user-info";
declare var jQuery:any;

@Component({
    selector: 'new-work',
    moduleId: module.id,
    templateUrl: 'new-work.component.html'
})

export class NewWorkComponent implements AfterViewInit {
    newWorkForm: FormGroup;
    formSubmitted = false;
    masterId: string;

    @ViewChild("newWorkModal")
    newWorkModal: SemanticModalComponent;

    @Input('requestId')
    requestId: string;

    @Output() onSave = new EventEmitter<boolean>();

    constructor(formBuilder: FormBuilder, private workService: WorkService, private elementRef: ElementRef,
    private zone: NgZone) {
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
            new UserInfo(this.newWorkForm.value.master),
            this.requestId
        );


        this.workService.create(work).subscribe(
            response => console.log("success"));
        this.newWorkModal.hide();
        this.newWorkForm.reset();

        this.onSave.emit(true);
    }

    ngAfterViewInit(): void {
        jQuery(this.elementRef.nativeElement).find('.search.selection.dropdown.status').dropdown({allowTab:false});
        jQuery(this.elementRef.nativeElement).find('.search.selection.dropdown.master').dropdown({allowTab:false});
    }

    /*reload(): void {
        this.zone.runOutsideAngular(() => {
            location.reload();
        });
    }*/
}