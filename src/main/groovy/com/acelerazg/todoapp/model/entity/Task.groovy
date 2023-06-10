package com.acelerazg.todoapp.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    String name

    String description

    String endDate

    String endTime

    String priority

    String category

    String status



}
