package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer PostId;
@NotNull
private String message;

@OneToMany(cascade =CascadeType.ALL,mappedBy="post")
@JsonIgnore
private List<Comment> comments= new ArrayList<>();
}
