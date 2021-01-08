import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

import { FilmService } from '../film.service';
import { IFilm } from '../ifilm';
import { BaseDetailsComponent, Globals, PickerDialogService, ErrorService } from 'src/app/common/shared';

import { LanguageService } from 'src/app/entities/language/language.service';

@Component({
  selector: 'app-film-details',
  templateUrl: './film-details.component.html',
  styleUrls: ['./film-details.component.scss']
})
export class FilmDetailsComponent extends BaseDetailsComponent<IFilm> implements OnInit {
	title = 'Film';
	parentUrl = 'film';
	constructor(
		public formBuilder: FormBuilder,
		public router: Router,
		public route: ActivatedRoute,
		public dialog: MatDialog,
		public global: Globals,
		public filmService: FilmService,
		public pickerDialogService: PickerDialogService,
		public errorService: ErrorService,
		public languageService: LanguageService,
	) {
		super(formBuilder, router, route, dialog, global, pickerDialogService, filmService, errorService);
  }

	ngOnInit() {
		this.entityName = 'Film';
		this.setAssociations();
		super.ngOnInit();
		this.setForm();
    	this.getItem();
    	this.setPickerSearchListener();
	}
  
  setForm(){
    this.itemForm = this.formBuilder.group({
      description: [''],
      filmId: [{value: '', disabled: true}, Validators.required],
      lastUpdate: [''],
	  lastUpdateTime: [''],
      length: [''],
      rating: [''],
      rentalDuration: ['', Validators.required],
      rentalRate: ['', Validators.required],
      replacementCost: ['', Validators.required],
      title: ['', Validators.required],
      languageId: ['', Validators.required],
      languageDescriptiveField : ['', Validators.required],
      
    });
    
    this.fields = [
			
        {
		  name: 'description',
		  label: 'description',
		  isRequired: false,
		  isAutoGenerated: false,
	      type: 'string',
	    },
			
			
        {
		  name: 'lastUpdate',
		  label: 'last Update',
		  isRequired: false,
		  isAutoGenerated: false,
		  type: 'date',
		},
		{
		  name: 'lastUpdateTime',
		  label: 'last Update Time',
		  isRequired: false,
		  isAutoGenerated: false,
		  type: 'time'
	    },
			
        {
		  name: 'length',
		  label: 'length',
		  isRequired: false,
		  isAutoGenerated: false,
	      type: 'number',
	    },
			
        {
		  name: 'rating',
		  label: 'rating',
		  isRequired: false,
		  isAutoGenerated: false,
	      type: 'string',
	    },
			
        {
		  name: 'rentalDuration',
		  label: 'rental Duration',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'number',
	    },
			
        {
		  name: 'rentalRate',
		  label: 'rental Rate',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'number',
	    },
			
        {
		  name: 'replacementCost',
		  label: 'replacement Cost',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'number',
	    },
			
        {
		  name: 'title',
		  label: 'title',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'string',
	    },
      ];
      
  }
  
  onItemFetched(item: IFilm) {
    this.item = item;
    this.itemForm.patchValue(item);
    this.itemForm.get('lastUpdate').setValue(item.lastUpdate? new Date(item.lastUpdate): null);
    this.itemForm.get('lastUpdateTime').setValue(this.filmService.formatDateStringToAMPM(item.lastUpdate));
  }
  
  setAssociations(){
    this.associations = [
      {
        column: [
	        {
	          key: 'filmId',
	          value: undefined,
	          referencedkey: 'filmId'
			},
		],
		isParent: true,
		table: 'filmActor',
		type: 'OneToMany',
		label: 'filmActors',
		},
      {
        column: [
	        {
	          key: 'filmId',
	          value: undefined,
	          referencedkey: 'filmId'
			},
		],
		isParent: true,
		table: 'filmCategory',
		type: 'OneToMany',
		label: 'filmCategorys',
		},
      {
        column: [
	        {
	          key: 'filmId',
	          value: undefined,
	          referencedkey: 'filmId'
			},
		],
		isParent: true,
		table: 'inventory',
		type: 'OneToMany',
		label: 'inventorys',
		},
      {
        column: [
	        {
	          key: 'languageId',
	          value: undefined,
	          referencedkey: 'languageId'
			},
		],
		isParent: false,
		table: 'language',
		type: 'ManyToOne',
		label: 'language',
		service: this.languageService,
		descriptiveField: 'languageDescriptiveField',
	    referencedDescriptiveField: 'languageId',
		},
		];
		
		this.childAssociations = this.associations.filter(association => {
			return (association.isParent);
		});

		this.parentAssociations = this.associations.filter(association => {
			return (!association.isParent);
		});
	}
	
	onSubmit() {
		let film = this.itemForm.getRawValue();
	    film.lastUpdate = this.dataService.combineDateAndTime(film.lastUpdate, film.lastUpdateTime);
	    delete film.lastUpdateTime;
		super.onSubmit(film);
		
	}
}