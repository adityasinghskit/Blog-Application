package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer commentId;
@NotNull
private String message;
/*
@ManyToOne(cascade=CascadeType.ALL)
private Post post;
*/
}
